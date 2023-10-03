package com.example.it_demo_bottomnavigation_viewpager;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageAdapter extends FragmentStateAdapter {

    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentC fragmentC;

    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //position當前ViewPage編號
        switch (position) {
            case 0:
                fragmentA = new FragmentA();
                return fragmentA;
            case 1:
                fragmentB = new FragmentB();
                return fragmentB;
            case 2:
                fragmentC = new FragmentC();
                return fragmentC;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
