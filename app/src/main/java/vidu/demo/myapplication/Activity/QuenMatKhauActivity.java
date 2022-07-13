package vidu.demo.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import vidu.demo.myapplication.R;

public class QuenMatKhauActivity extends AppCompatActivity {

    EditText edt_email;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_quen_mat_khau);
        edt_email = findViewById (R.id.edt_email_for_got);
        btn_send = findViewById (R.id.btn_forgotpass);

        btn_send.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(edt_email.getText ().toString ().equals ("")){
                    Toast.makeText (QuenMatKhauActivity.this, "Vui long nhap email", Toast.LENGTH_SHORT).show ();
                    return;
                }else if(!Patterns.EMAIL_ADDRESS.matcher (edt_email.getText ().toString ()).matches ()){
                    Toast.makeText (QuenMatKhauActivity.this, "Email sai dinh dang", Toast.LENGTH_SHORT).show ();
                    return;
                }else {
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance ();
                    firebaseAuth.sendPasswordResetEmail (edt_email.getText ().toString ()).addOnCompleteListener (new OnCompleteListener<Void> () {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful ()){
                                Toast.makeText (QuenMatKhauActivity.this, "Vui long check email", Toast.LENGTH_SHORT).show ();
                            }else {
                                Toast.makeText (QuenMatKhauActivity.this, "Email tim kiem khong ton tai", Toast.LENGTH_SHORT).show ();
                            }
                        }
                    });
                }
            }
        });
    }
}