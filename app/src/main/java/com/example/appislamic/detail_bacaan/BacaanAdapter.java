package com.example.appislamic.detail_bacaan;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appislamic.databinding.ItemBacaanBinding;
import com.example.appislamic.model.Bacaan;

public class BacaanAdapter extends ListAdapter <Bacaan, BacaanAdapter.BacaanViewHolder> {

   protected BacaanAdapter(@NonNull DiffUtil.ItemCallback<Bacaan> diffCallback){
       super(diffCallback);
   }

   public static class DiffCallback extends DiffUtil.ItemCallback<Bacaan> {

       @Override
       public  boolean areItemsTheSame(@NonNull Bacaan oldItem, @NonNull Bacaan newItem) {
           return  oldItem == newItem;
       }

       @Override
       public boolean areContentsTheSame(@NonNull Bacaan oldItem, @NonNull Bacaan newItem) {
           return oldItem.getLatin().equals(newItem.getLatin());
       }
   }

   public static class BacaanViewHolder extends RecyclerView.ViewHolder {
       private ItemBacaanBinding binding;

       public BacaanViewHolder(ItemBacaanBinding binding) {
           super(binding.getRoot());
           this.binding = binding;
       }

       private void bind(Bacaan bacaan) {
           binding.tvNama.setText(bacaan.getNama());
           binding.tvArab.setText(bacaan.getArab());
           binding.tvLatin.setText(bacaan.getLatin());
           binding.tvTerjemahan.setText(bacaan.getTerjemahan());
       }
   }

   @NonNull
   @Override
    public  BacaanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       return new BacaanViewHolder(ItemBacaanBinding.inflate(layoutInflater, parent, false));
   }

    @Override
    public void onBindViewHolder(@NonNull BacaanViewHolder holder, int position) {
        Bacaan bacaan = getItem(position);
        holder.bind(bacaan);
    }
}
