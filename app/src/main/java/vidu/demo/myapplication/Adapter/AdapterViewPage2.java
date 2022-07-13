package vidu.demo.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vidu.demo.myapplication.Fragmnet.CaNhanFragment;
import vidu.demo.myapplication.Fragmnet.GioHangFragment;
import vidu.demo.myapplication.Fragmnet.HomeFragment;
import vidu.demo.myapplication.Fragmnet.SanPhamFragment;

public class AdapterViewPage2 extends FragmentStateAdapter {


    public AdapterViewPage2(@NonNull FragmentActivity fragmentActivity) {
        super (fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new HomeFragment ();
            case 1:
                return new SanPhamFragment ();
            case 2 :
                return new GioHangFragment ();
            case 3:
                return new CaNhanFragment ();
            default:
                return new HomeFragment ();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
