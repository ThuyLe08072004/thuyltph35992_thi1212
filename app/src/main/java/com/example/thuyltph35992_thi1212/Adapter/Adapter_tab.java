package com.example.thuyltph35992_thi1212.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thuyltph35992_thi1212.Fragment.Frag_list;
import com.example.thuyltph35992_thi1212.Fragment.Frag_none;

public class Adapter_tab extends FragmentStateAdapter {
int size = 2;

    public Adapter_tab(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new Frag_list();
        }else {
            return new Frag_none();
        }

    }

    @Override
    public int getItemCount() {
        return size;
    }
}
