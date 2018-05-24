package com.example.small_lian_yuekao.presenter.contract;

import com.example.small_lian_yuekao.presenter.BasePersenter;
import com.example.small_lian_yuekao.ui.BaseView;

/**
 * Created by 金雪晗 on 2018/5/23.
 */

public interface LoginContract {
    interface ILoginPersenter extends BasePersenter {
        void login(String num, String pwd);
    }

    interface ILoginView<ILoginPersenter> extends BaseView<ILoginPersenter> {
        void UpDateUI(String orgId, String key, String userId,String zhi);
    }
}
