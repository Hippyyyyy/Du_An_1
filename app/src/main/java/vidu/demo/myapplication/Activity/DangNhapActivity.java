package vidu.demo.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vidu.demo.myapplication.R;

public class DangNhapActivity extends AppCompatActivity {
    Button btn_dang_nhap;
    TextView txt_dang_ki , txt_quen_mk;
    EditText edt_email , edt_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dang_nhap);
        btn_dang_nhap = findViewById (R.id.btn_dang_nhap);
        txt_dang_ki = findViewById (R.id.txt_dang_ki);
        txt_quen_mk = findViewById (R.id.txt_for_got_pass);
        edt_email = findViewById (R.id.edt_email_dang_nhap);
        edt_pass = findViewById (R.id.edt_pass_dang_nhap);
        btn_dang_nhap.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                DangNhap ();
            }
        });
        txt_dang_ki.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (DangNhapActivity.this,DangKiActivity.class));
            }
        });
        txt_quen_mk.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (DangNhapActivity.this,QuenMatKhauActivity.class));
            }
        });
    }
    public void DangNhap(){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance ();
        if(edt_email.getText ().toString ().equals ("")){
            Toast.makeText (this, "Vui long nhap email", Toast.LENGTH_SHORT).show ();
            return;
        }else if(!Patterns.EMAIL_ADDRESS.matcher (edt_email.getText ().toString ()).matches ()){
            Toast.makeText (this, "Email sai dinh dang", Toast.LENGTH_SHORT).show ();
            return;
        }else if(edt_pass.getText ().toString ().equals ("")){
            Toast.makeText (this, "Vui long nhap password", Toast.LENGTH_SHORT).show ();
            return;
        }else {
            firebaseAuth.signInWithEmailAndPassword (edt_email.getText ().toString (),edt_pass.getText ().toString ()).addOnCompleteListener (this, new OnCompleteListener<AuthResult> () {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful ()){
                        startActivity (new Intent (DangNhapActivity.this,TrangChuActivity.class));
                        Toast.makeText (DangNhapActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show ();
                    }else {
                        Toast.makeText (DangNhapActivity.this, "Tai khoan hoac mat khau  khong dung", Toast.LENGTH_SHORT).show ();
                    }
                }
            });
        }
    }
}