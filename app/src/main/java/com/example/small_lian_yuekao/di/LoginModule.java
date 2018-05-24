package com.example.small_lian_yuekao.di;

import com.example.small_lian_yuekao.date.model.LoginModel;
import com.example.small_lian_yuekao.date.model.LoginModelImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 金雪晗 on 2018/5/23.
 */
@Module
public class LoginModule {
    @Provides
    public LoginModelImpl getFun() {
        return new LoginModelImpl();
    }
}
