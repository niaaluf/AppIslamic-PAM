package com.example.appislamic.detail_bacaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.appislamic.R;
import com.example.appislamic.databinding.ActivityDetailBacaanBinding;
import com.example.appislamic.model.Bacaan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DetailBacaanActivity extends AppCompatActivity {

    private ActivityDetailBacaanBinding binding;
    public final static String EXTRA_SHOLAT = "sholat";
    private DatabaseReference mDatabase;
    private BacaanAdapter adapter;
    private String sholat;
    final String TAG = "DetailBacaanActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBacaanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        getData();
    }


    private void initView(){
        sholat = getIntent().getStringExtra(EXTRA_SHOLAT);
        setTitle("Bacaan Sholat" + sholat);

        adapter = new BacaanAdapter(new BacaanAdapter.DiffCallback());
        binding.rvBacaan.setLayoutManager(new LinearLayoutManager(this));
        binding.rvBacaan.setAdapter(adapter);
    }

    //Mengambil informasi atau data dari database
    private void getData(){
        mDatabase = FirebaseDatabase.getInstance().getReference();

        List<Bacaan> listBacaan = new ArrayList<>();
        mDatabase.child("bacaan").get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e(TAG,"Error getting Data", task.getException());
            } else {
                for (DataSnapshot data : task.getResult().getChildren()){
                    Bacaan bacaan = data.getValue(Bacaan.class);
                    listBacaan.add(bacaan);
                }

                //set Qunut
                if (sholat.equals((getString(R.string.shubuh)))) {
                    Bacaan qunut = listBacaan.get(listBacaan.size()-1);
                    listBacaan.remove(listBacaan.size()-1);
                    listBacaan.add(5, qunut);
                }else {
                    listBacaan.remove(listBacaan.size()-1);
                }

                adapter.submitList(listBacaan);
            }
        });
    }
}