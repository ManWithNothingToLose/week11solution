package com.example.week11solution;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private EditText searchBar;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        searchBar = findViewById(R.id.searchBar);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: tab.setText("Teams"); break;
                        case 1: tab.setText("Players"); break;
                        case 2: tab.setText("Matches"); break;
                    }
                }).attach();

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                Fragment current = getSupportFragmentManager()
                        .findFragmentByTag("f" + viewPager.getCurrentItem());

                if (current instanceof TeamFragment) {
                    ((TeamFragment) current).filter(s.toString());
                } else if (current instanceof PlayerFragment) {
                    ((PlayerFragment) current).filter(s.toString());
                } else if (current instanceof MatchFragment) {
                    ((MatchFragment) current).filter(s.toString());
                }
            }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    public EditText getSearchBar() {
        return searchBar;
    }
}
