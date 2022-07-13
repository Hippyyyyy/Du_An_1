package vidu.demo.myapplication.Fragmnet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import vidu.demo.myapplication.Adapter.AdapterTablayout_SanPham;
import vidu.demo.myapplication.R;


public class SanPhamFragment extends Fragment {

    TabLayout mTableLayout;
    ViewPager2 mViewPager2;

    public SanPhamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_san_pham, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        mTableLayout = view.findViewById (R.id.tab_layout_sp);
        mViewPager2 = view.findViewById (R.id.view_page2_sp);

        AdapterTablayout_SanPham adapterTablayout_sanPham = new AdapterTablayout_SanPham (getActivity ());
        mViewPager2.setAdapter (adapterTablayout_sanPham);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator (mTableLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy () {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText ("Bánh");
                        break;
                    case 1:
                        tab.setText ("Nước");
                        break;
                }
            }
        });
        tabLayoutMediator.attach ();
    }
}