package com.roberterrera.gifsearch.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.roberterrera.gifsearch.databinding.ListItemTrendingBinding;

/**
 * Created by Rob on 8/16/16.
 */
public class TrendingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private final ListItemTrendingBinding mBinding;
    private ItemClickListener itemClickListener;
    public ImageView gifStill;

    public TrendingViewHolder(ListItemTrendingBinding binding) {
        super(binding.getRoot());
        mBinding = binding;

        gifStill = mBinding.imageViewFixedwidthGif;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
}