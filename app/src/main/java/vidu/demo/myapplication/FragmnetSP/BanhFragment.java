package vidu.demo.myapplication.FragmnetSP;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import vidu.demo.myapplication.Adapter.AdapterBanhSP;
import vidu.demo.myapplication.Model.Banh;
import vidu.demo.myapplication.R;


public class BanhFragment extends Fragment {

    RecyclerView mRecyclerView;
    AdapterBanhSP adapterBanhSP;
    ArrayList<Banh> arrayList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public BanhFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_banh, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        mRecyclerView = view.findViewById (R.id.recy_banh);
        firebaseDatabase = FirebaseDatabase.getInstance ();
        databaseReference = firebaseDatabase.getReference ("Banh");

        mRecyclerView.hasFixedSize ();
        arrayList = new ArrayList<> ();
        mRecyclerView.setLayoutManager (new GridLayoutManager (getActivity (),2));
        adapterBanhSP = new AdapterBanhSP (getActivity (),arrayList);
        mRecyclerView.setAdapter (adapterBanhSP);

        databaseReference.addChildEventListener (new ChildEventListener () {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(arrayList != null) {
                   Banh banh = snapshot.getValue (Banh.class);
                   arrayList.add (banh);
                }

                adapterBanhSP.notifyDataSetChanged ();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}