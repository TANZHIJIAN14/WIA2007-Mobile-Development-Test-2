package com.example.rethinkyourdrink.ui.summary.tab_item;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.rethinkyourdrink.ui.summary.tab_item.DetailsFragment;
import com.example.rethinkyourdrink.ui.summary.tab_item.HistoryFragment;

public class MyViewPageAdapter extends FragmentStateAdapter {
    public MyViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DetailsFragment();
            case 1:
                return new HistoryFragment();
            default:
                return new DetailsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
