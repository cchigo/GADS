package me.chigo.gads;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import me.chigo.gads.fragment.leader.FragmentLeader;
import me.chigo.gads.fragment.skills.FragmentSkills;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentLeader();
            case 1:
                return new FragmentSkills();
            default:
                return new FragmentLeader();
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
