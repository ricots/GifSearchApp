package com.roberterrera.gifsearch.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.roberterrera.gifsearch.R;

/**
 * Created by Rob on 8/16/16.
 */
public class TrendingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView gifStill;

    public Context context;
    private ItemClickListener itemClickListener;

    public TrendingViewHolder(View itemView) {
        super(itemView);

        gifStill = (ImageView) itemView.findViewById(R.id.imageView_fixedwidth_gif);

        context = itemView.getContext();
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