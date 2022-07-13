package vidu.demo.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vidu.demo.myapplication.Fragmnet.HomeFragment;
import vidu.demo.myapplication.FragmnetSP.BanhFragment;
import vidu.demo.myapplication.FragmnetSP.NuocFragment;

public class AdapterTablayout_SanPham extends FragmentStateAdapter {


    public AdapterTablayout_SanPham(@NonNull FragmentActivity fragmentActivity) {
        super (fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new BanhFragment ();
            case 1:
                return new NuocFragment ();
        }
        return new HomeFragment ();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
