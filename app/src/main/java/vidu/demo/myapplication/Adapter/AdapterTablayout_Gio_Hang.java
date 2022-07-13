package vidu.demo.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vidu.demo.myapplication.FragmentGioHang.HangDaChonFragment;
import vidu.demo.myapplication.FragmentGioHang.HoaDonFragment;

public class AdapterTablayout_Gio_Hang extends FragmentStateAdapter {
    public AdapterTablayout_Gio_Hang(@NonNull FragmentActivity fragmentActivity) {
        super (fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HangDaChonFragment ();
            case 1:
                return new HoaDonFragment ();
            default:
                return new HangDaChonFragment ();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
