package com.roberterrera.gifsearch.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.roberterrera.gifsearch.R;

/**
 * Created by Rob on 8/16/16.
 */
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView gifImage;

    public Context context;
    private ItemClickListener itemClickListener;

    public ViewHolder(View itemView) {
        super(itemView);

        gifImage = (ImageView) itemView.findViewById(R.id.imageView_gif);

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