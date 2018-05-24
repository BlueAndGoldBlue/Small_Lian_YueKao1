package com.example.small_lian_yuekao.date.http;



import com.example.small_lian_yuekao.date.bean.LueLogin;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;


/**
 * Created by 金雪晗 on 2018/5/23.
 */

public interface JieKou {
    @FormUrlEncoded
    @POST("loginOrg")
    Observable<LueLogin> sendLogin(@Field("phone") String phone, @Field("password") String password);
}
