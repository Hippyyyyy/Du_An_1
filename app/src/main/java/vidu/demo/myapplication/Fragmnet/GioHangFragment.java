package vidu.demo.myapplication.Fragmnet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import vidu.demo.myapplication.Adapter.AdapterTablayout_Gio_Hang;
import vidu.demo.myapplication.R;


public class GioHangFragment extends Fragment {

    TabLayout mTabLayout;
    ViewPager2 mViewPager2;

    public GioHangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_gio_hang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        mTabLayout = view.findViewById (R.id.tablayoy_giohang);
        mViewPager2 = view.findViewById (R.id.view_page2_gio_hang);

        AdapterTablayout_Gio_Hang adapterTablayout_gio_hang =  new AdapterTablayout_Gio_Hang (getActivity ());
        mViewPager2.setAdapter (adapterTablayout_gio_hang);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator (mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy () {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText ("Hàng chờ ");
                        break;
                    case 1:
                        tab.setText ("Hóa đơn");
                        break;

                }
            }
        });
        tabLayoutMediator.attach ();
    }
}