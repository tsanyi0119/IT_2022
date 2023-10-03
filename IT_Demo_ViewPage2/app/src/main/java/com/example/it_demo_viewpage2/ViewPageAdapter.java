package com.example.it_demo_viewpage2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position){
            case 0:
                return new FragmentA();
            case 1:
                return new FragmentB();
            default:
                return new FragmentC();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
