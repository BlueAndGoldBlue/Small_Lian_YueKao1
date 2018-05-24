package com.example.small_lian_yuekao.di;

import com.example.small_lian_yuekao.presenter.impl.LoginPersenterImpl;

import dagger.Component;

/**
 * Created by 金雪晗 on 2018/5/23.
 */
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void injcy(LoginPersenterImpl loginPersenter);
}
