package com.example.appislamic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appislamic.bacaan.BacaanActivity;
import com.example.appislamic.detail_niat.DetailNiat;
import com.example.appislamic.model.Niat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnLogout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
    }

    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    //Untuk memanggil layout baru
    public void linearNiatShalat(View view) {
        startActivity(new Intent(this, DetailNiat.class));
    }

    public void linearBacaanShalat(View view) {
        startActivity(new Intent(this, BacaanActivity.class));
    }
}