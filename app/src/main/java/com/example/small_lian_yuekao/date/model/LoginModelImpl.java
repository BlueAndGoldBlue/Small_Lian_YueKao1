package com.example.small_lian_yuekao.date.model;

import android.database.Observable;
import android.util.Log;

import com.example.small_lian_yuekao.date.bean.LueLogin;
import com.example.small_lian_yuekao.date.contetn.Contract;
import com.example.small_lian_yuekao.date.http.JieKou;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 金雪晗 on 2018/5/23.
 */

public class LoginModelImpl implements LoginModel {

    private String id;
    private String key;
    private String userId;

    @Override
    public void sendDate(String num, String pwd, final DateShuJu listen) {
        Log.e("aaaa", num + "----------" + pwd);
        String zhi = "";
        if (num.equals("13252028551") && pwd.equals("123456")) {
            Log.e("ssss", "sssssss");
            Retrofit build = new Retrofit.Builder()
                    .baseUrl(Contract.Base_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            JieKou jieKou = build.create(JieKou.class);
            rx.Observable<LueLogin> lueLoginObservable = jieKou.sendLogin(num, pwd);
            lueLoginObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LueLogin>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("LoginModelImpl=========", e + "");
                        }

                        @Override
                        public void onNext(LueLogin lueLogin) {
                            List<LueLogin.OrgBean> org = lueLogin.getOrg();
                            for (int i = 0; i < org.size(); i++) {
                                id = org.get(i).getId();
                            }
                            key = lueLogin.getUser().getKey();
                            userId = lueLogin.getUser().getUserId();

                        }
                    });
            zhi = "登录成功";
        } else {
            Log.e("ssssaaaaaaaaaas", "sssssss");
            zhi = "登录失败";
        }
        listen.ShuJuDate(id, key, userId, zhi);
    }
}
