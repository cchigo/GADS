package me.chigo.gads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import me.chigo.gads.utils.AppNavigator;

public class MainActivity extends AppCompatActivity {
    TextView submitTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(new ViewPagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabs);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

              //  tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                switch (position){
                    case 0: {
                        tab.setText("Learning Leaders");

                        //tab.setText((CharSequence) ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));

                        break;
                    }
                    case 1: {
                        tab.setText("Skill IQ Leaders");
                        break;
                    }

                }
            }
        }
        );
        tabLayoutMediator.attach();

//
//        submitTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AppNavigator(MainActivity.this).navigateToSubmit();
//            }
//        });
    }


}