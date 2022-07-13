package vidu.demo.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vidu.demo.myapplication.Model.SanPham;
import vidu.demo.myapplication.R;

public class ChiTietSPActivity extends AppCompatActivity {
    ImageView img_ct_sp;
    TextView txt_ten_sp,txt_gia_sp,txt_mota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_chi_tiet_spactivity);
        Init ();
        Intent intent = getIntent ();
        String AnhSP = intent.getStringExtra ("anhSP");
        String TenSP = intent.getStringExtra ("tenSP");
        int GiaSP = intent.getIntExtra ("giaSP",0);
        String moTaSP = intent.getStringExtra ("moTa");

        Picasso.get ().load (AnhSP).into (img_ct_sp);
        txt_ten_sp.setText (TenSP);
        txt_gia_sp.setText ("Giá : " + GiaSP + "$");
        txt_mota.setText (moTaSP);
    }
    public void Init(){
        img_ct_sp = findViewById (R.id.img_anh_ctsp);
        txt_ten_sp = findViewById (R.id.txt_ct_tensp);
        txt_gia_sp =  findViewById (R.id.txt_ct_gia_sp);
        txt_mota = findViewById (R.id.txt_mota_sp);
    }
}