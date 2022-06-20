package com.example.appislamic.bacaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appislamic.R;
import com.example.appislamic.databinding.ActivityBacaanBinding;
import com.example.appislamic.detail_bacaan.DetailBacaanActivity;

public class BacaanActivity extends AppCompatActivity {

    ActivityBacaanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBacaanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView() {
        setTitle(getString(R.string.bacaan_sholat));

        binding.btnShubuh.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailBacaanActivity.class);
            intent.putExtra(DetailBacaanActivity.EXTRA_SHOLAT, getString(R.string.shubuh));
            startActivity(intent);
        });

        binding.btnZuhur.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailBacaanActivity.class);
            intent.putExtra(DetailBacaanActivity.EXTRA_SHOLAT, getString(R.string.zuhur));
            startActivity(intent);
        });

        binding.btnAshar.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailBacaanActivity.class);
            intent.putExtra(DetailBacaanActivity.EXTRA_SHOLAT, getString(R.string.ashar));
            startActivity(intent);
        });

        binding.btnMaghrib.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailBacaanActivity.class);
            intent.putExtra(DetailBacaanActivity.EXTRA_SHOLAT, getString(R.string.maghrib));
            startActivity(intent);
        });

        binding.btnIsya.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailBacaanActivity.class);
            intent.putExtra(DetailBacaanActivity.EXTRA_SHOLAT, getString(R.string.isya));
            startActivity(intent);
        });
    }
}