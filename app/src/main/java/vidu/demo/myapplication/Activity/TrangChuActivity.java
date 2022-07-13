package vidu.demo.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayoutMediator;

import vidu.demo.myapplication.Adapter.AdapterViewPage2;
import vidu.demo.myapplication.R;

public class TrangChuActivity extends AppCompatActivity {
    BottomNavigationView bottom_navi;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home);
        bottom_navi = findViewById (R.id.bottom_navigation);
        viewPager2 = findViewById (R.id.view_page2);
        AdapterViewPage2 adapterViewPage2 = new AdapterViewPage2 (this);
        viewPager2.setAdapter (adapterViewPage2);

        bottom_navi.setOnItemSelectedListener (new NavigationBarView.OnItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId ()){
                    case R.id.item_home:
                        viewPager2.setCurrentItem (0);
                        break;
                    case R.id.item_san_pham:
                        viewPager2.setCurrentItem (1);
                        break;
                    case R.id.item_gio_hang:
                        viewPager2.setCurrentItem (2);
                        break;
                    case R.id.item_tt_cn:
                        viewPager2.setCurrentItem (3);
                        break;
                }
                return true;
            }
        });
    }
}