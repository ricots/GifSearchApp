package com.roberterrera.gifsearch.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.roberterrera.gifsearch.R;
import com.roberterrera.gifsearch.model.giphyapi.Images;
import com.roberterrera.gifsearch.view.DetailActivity;

import java.util.List;

/**
 * Created by Rob on 8/16/16.
 */
public class TrendingAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Images> trendingImagesList;

    private Context context;

    public TrendingAdapter(List<Images> trendingImagesList, Context context){
        this.trendingImagesList = trendingImagesList;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.list_item_trending, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try {
            String imageUrl = trendingImagesList.get(position).getFixedWidth().getUrl();

            Glide.with(context)
                    .load(imageUrl)
                    .asGif()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.drawable.ic_burst_mode)
                    .into(holder.gifImage);

        } catch (NullPointerException e){
            Log.e("ONBINDVIEWHOLDER", e.getMessage());
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                /* Open the full-size of the image with option to share. */
                try {
                    String website = trendingImagesList.get(pos).getOriginal().getUrl();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("original", website);
                    context.startActivity(intent);

                } catch (NullPointerException e) {
                    Log.e("ONITEMCLICK", e.getMessage());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return trendingImagesList.size();
    }
}