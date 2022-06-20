package com.example.appislamic;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appislamic.databinding.ItemNiatBinding;
import com.example.appislamic.databinding.ItemBacaanBinding;
import com.example.appislamic.model.Niat;
import com.example.appislamic.model.Bacaan;

public class NiatAdapter extends ListAdapter <Niat, NiatAdapter.NiatViewHolder> {

    public NiatAdapter(@NonNull DiffUtil.ItemCallback<Niat> diffCallback) {
        super(diffCallback);
    }

    public static class DiffCallback extends DiffUtil.ItemCallback<Niat> {

        @Override
        public boolean areItemsTheSame(@NonNull Niat oldItem, @NonNull Niat newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Niat oldItem, @NonNull Niat newItem) {
            return oldItem.getLatin().equals(newItem.getLatin());
        }

    }

    public static class NiatViewHolder extends RecyclerView.ViewHolder {
        private ItemNiatBinding binding;

        public NiatViewHolder(ItemNiatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(Niat niat) {
            binding.tvSholat.setText(niat.getSholat());
            binding.tvArab.setText(niat.getArab());
            binding.tvLatin.setText(niat.getLatin());
            binding.tvTerjemahan.setText(niat.getTerjemahan());
        }
    }

    @NonNull
    @Override
    public NiatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new NiatViewHolder(ItemNiatBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NiatViewHolder holder, int position) {
        Niat niat = getItem(position);
        holder.bind(niat);
    }
}
