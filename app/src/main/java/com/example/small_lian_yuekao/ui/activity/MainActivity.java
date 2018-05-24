package com.example.small_lian_yuekao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.small_lian_yuekao.R;
import com.example.small_lian_yuekao.date.bean.LueKey;
import com.example.small_lian_yuekao.presenter.contract.LoginContract;
import com.example.small_lian_yuekao.presenter.impl.LoginPersenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginContract.ILoginView<LoginContract.ILoginPersenter> {

    @BindView(R.id.mnum_login)
    EditText mnumLogin;
    @BindView(R.id.mpwd_login)
    EditText mpwdLogin;
    @BindView(R.id.mlog_login)
    Button mlogLogin;
    private LoginContract.ILoginPersenter iLoginPersenter1;
    private List<LueKey> mlist = new ArrayList<>();
    private String zhi1;
    private LueKey lueKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new LoginPersenterImpl(this);

        initDate();
    }

    private void initDate() {
        mlogLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = mnumLogin.getText().toString();
                String string1 = mpwdLogin.getText().toString();
                iLoginPersenter1.login(string,string1);
                Log.e("wwww", string + "------" + string1);
                if (zhi1.equals("登录成功")) {
                    Intent intent = new Intent(MainActivity.this, FrigmentActivity.class);
                    intent.putExtra("Luekey", lueKey);
                    startActivity(intent);
                }
                if (zhi1.equals("登录失败")) {
                    Toast.makeText(MainActivity.this, zhi1, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void setPersenter(LoginContract.ILoginPersenter iLoginPersenter) {
        iLoginPersenter1 = iLoginPersenter;
    }

    @Override
    public void UpDateUI(String orgId, String key, String userId, String zhi) {
        lueKey = new LueKey(orgId, key, userId);
        mlist.add(lueKey);
        zhi1 = zhi;

    }
}
