package com.example.thuyltph35992_thi1212;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.thuyltph35992_thi1212.Adapter.Adapter_tab;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    Adapter_tab adapterTab;
    ViewPager2 pager2;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapterTab = new Adapter_tab(this);
        pager2 = findViewById(R.id.vp2);
        tabLayout = findViewById(R.id.tab_);

        pager2.setAdapter(adapterTab);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position==0){
                    tab.setText("Danh sách");
                }else {
                    tab.setText("Thông Tin");
                }
            }
        });
        tabLayoutMediator.attach();
    }
    }