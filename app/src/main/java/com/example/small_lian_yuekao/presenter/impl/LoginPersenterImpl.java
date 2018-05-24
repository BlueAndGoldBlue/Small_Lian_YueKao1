package com.example.small_lian_yuekao.presenter.impl;

import com.example.small_lian_yuekao.date.model.LoginModel;
import com.example.small_lian_yuekao.date.model.LoginModelImpl;
import com.example.small_lian_yuekao.di.DaggerLoginComponent;
import com.example.small_lian_yuekao.di.LoginModule;
import com.example.small_lian_yuekao.presenter.contract.LoginContract;
import com.example.small_lian_yuekao.ui.activity.MainActivity;

import javax.inject.Inject;

/**
 * Created by 金雪晗 on 2018/5/23.
 */

public class LoginPersenterImpl implements LoginContract.ILoginPersenter {

    private LoginContract.ILoginView iLoginView1;
    @Inject
    LoginModelImpl loginModel;

    public LoginPersenterImpl(LoginContract.ILoginView iLoginView) {
        this.iLoginView1 = iLoginView;
        iLoginView1.setPersenter(this);
        DaggerLoginComponent.builder().loginModule(new LoginModule()).build().injcy(this);
    }

    @Override
    public void login(String num, String pwd) {
        loginModel.sendDate(num, pwd, new LoginModel.DateShuJu() {
            @Override
            public void ShuJuDate(String orgId, String key, String userId, String zhi) {
                iLoginView1.UpDateUI(orgId, key, userId,zhi);
            }
        });
    }
}
