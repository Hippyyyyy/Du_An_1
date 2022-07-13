package vidu.demo.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import vidu.demo.myapplication.Activity.ChiTietSPActivity;
import vidu.demo.myapplication.Fragmnet.HomeFragment;
import vidu.demo.myapplication.Model.SanPham;
import vidu.demo.myapplication.R;

public class AdapterSanPhamHome extends RecyclerView.Adapter<AdapterSanPhamHome.ViewHodelSanPhamhome>{
    private Context context;
    private List<SanPham> list;
    private HomeFragment homeFragment;

    public AdapterSanPhamHome(Context context, List<SanPham> list, HomeFragment homeFragment) {
        this.context = context;
        this.list = list;
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public ViewHodelSanPhamhome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (context).inflate (R.layout.item_recy_san_pham_home,null);
        return new ViewHodelSanPhamhome (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelSanPhamhome holder, int position) {
        SanPham sp = list.get (position);
        Picasso.get ().load (sp.getAnhSP ()).into (holder.imageView);
        holder.txt_ten_sp.setText (sp.getTenSP ());
        Log.d ("TAG", "onBindViewHolder: " + sp.getTenSP ());
        holder.layout.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                homeFragment.getSP (sp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    class ViewHodelSanPhamhome extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt_ten_sp;
        LinearLayout layout;
        public ViewHodelSanPhamhome(@NonNull View itemView) {
            super (itemView);
            imageView = itemView.findViewById (R.id.image_sanpham_home);
            txt_ten_sp =  itemView.findViewById (R.id.txt_ten_sp_home);
            layout = itemView.findViewById (R.id.linear_layout);
        }
    }
}
