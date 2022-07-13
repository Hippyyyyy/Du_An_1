package vidu.demo.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import vidu.demo.myapplication.R;

public class DangKiActivity extends AppCompatActivity {

    EditText edt_email,edt_pass,edt_nhap_lai_pass;
    Button btn_dang_ki;
    FirebaseAuth fireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dang_ki);
        fireBaseAuth = FirebaseAuth.getInstance ();
        Init ();
        Dangki ();
    }
    public void Init(){
        edt_email = findViewById (R.id.edt_email_dang_ki);
        edt_pass = findViewById (R.id.edt_pass_dangki);
        edt_nhap_lai_pass = findViewById (R.id.edt_nhap_lai_pass_dangki);
        btn_dang_ki = findViewById (R.id.btn_dang_ki);
    }
    public void Dangki(){
        btn_dang_ki.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(edt_email.getText ().toString ().equals ("")){
                    Toast.makeText (DangKiActivity.this, "Vui long nhap email", Toast.LENGTH_SHORT).show ();
                    return;
                }else if(!Patterns.EMAIL_ADDRESS.matcher (edt_email.getText ().toString ()).matches ()){
                    Toast.makeText (DangKiActivity.this, "Email sai dinh dang", Toast.LENGTH_SHORT).show ();
                    return;
                }else if(edt_pass.getText ().toString ().equals ("")){
                    Toast.makeText (DangKiActivity.this, "Vui long nhap pass", Toast.LENGTH_SHORT).show ();
                    return;
                }else if(edt_nhap_lai_pass.getText ().toString ().equals ("")){
                    Toast.makeText (DangKiActivity.this, "Vui long xac nhan pass word", Toast.LENGTH_SHORT).show ();
                    return;
                }else if(!edt_nhap_lai_pass.getText ().toString ().equals (edt_pass.getText ().toString ())){
                    Toast.makeText (DangKiActivity.this, "Mat khau xac nhan khong khop", Toast.LENGTH_SHORT).show ();
                    return;
                }else {
                    String email = edt_email.getText ().toString ();
                    String pass = edt_pass.getText ().toString ();
                    fireBaseAuth.createUserWithEmailAndPassword (email,pass).addOnCompleteListener (DangKiActivity.this, new OnCompleteListener<AuthResult> () {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful ()){
                                Toast.makeText (DangKiActivity.this, "Dang ki thanh cong", Toast.LENGTH_SHORT).show ();
                                startActivity (new Intent (DangKiActivity.this,DangNhapActivity.class));
                            finishAffinity ();
                            }else {
                                Toast.makeText (DangKiActivity.this, "Dang ki that bai", Toast.LENGTH_SHORT).show ();
                            }
                        }
                    });
                }
            }
        });
    }
}