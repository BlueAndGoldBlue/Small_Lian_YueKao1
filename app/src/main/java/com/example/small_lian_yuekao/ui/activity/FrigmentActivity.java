package com.example.small_lian_yuekao.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.small_lian_yuekao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FrigmentActivity extends AppCompatActivity {

    @BindView(R.id.text_one)
    TextView textOne;
    @BindView(R.id.mViewPage)
    ViewPager mViewPage;
    @BindView(R.id.mTab)
    TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frigment);
        ButterKnife.bind(this);
    }
}
