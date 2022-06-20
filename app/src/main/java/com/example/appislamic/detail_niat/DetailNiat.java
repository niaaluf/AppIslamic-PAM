package com.example.appislamic.detail_niat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.appislamic.NiatAdapter;
import com.example.appislamic.bacaan.BacaanActivity;
import com.example.appislamic.databinding.ActivityDetailNiatBinding;
import com.example.appislamic.model.Niat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DetailNiat extends AppCompatActivity {

    private ActivityDetailNiatBinding binding;
    private DatabaseReference mDatabase;
    private NiatAdapter adapter;
    final String TAG = "DetailNiat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailNiatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        getData();
    }

    private void initView() {
        adapter = new NiatAdapter(new NiatAdapter.DiffCallback());
        binding.rvNiat.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNiat.setAdapter(adapter);
    }

    //Mengambil informasi atau data dari database
    private void getData() {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        List<Niat> listNiat = new ArrayList<>();
        mDatabase.child("niat").get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e(TAG, "Error getting data", task.getException());
            } else {
                for (DataSnapshot data : task.getResult().getChildren()) {
                    Niat niat = data.getValue(Niat.class);
                    String sholat = data.getKey().substring(0, 1).toUpperCase() + data.getKey().substring(1);
                    niat.setSholat(sholat);
                    listNiat.add(niat);
                }
                adapter.submitList(listNiat);
            }
        });
    }
}