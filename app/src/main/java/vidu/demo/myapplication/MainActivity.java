package vidu.demo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import vidu.demo.myapplication.Activity.DangNhapActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        new Handler ().postDelayed (new Runnable () {
            @Override
            public void run() {
                startActivity (new Intent (MainActivity.this, DangNhapActivity.class));
            }
        },2000);

    }
}