package com.example.small_lian_yuekao.date.model;

/**
 * Created by 金雪晗 on 2018/5/23.
 */

public interface LoginModel {
    void sendDate(String num,String pwd,DateShuJu listen);

    interface DateShuJu {
        void ShuJuDate(String orgId, String key, String userId,String zhi);
    }
}
