package com.roberterrera.gifsearch.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.roberterrera.gifsearch.R;
import com.roberterrera.gifsearch.model.trending.Datum;
import com.roberterrera.gifsearch.model.trending.Images;

import java.util.List;

/**
 * Created by Rob on 8/16/16.
 */
public class TrendingAdapter extends RecyclerView.Adapter<TrendingViewHolder> {

    private final List<Images> trendingImagesList;
    private final List<Datum> trendingList;
    private String imageUrl;

    private Context context;

    public TrendingAdapter(List<Images> trendingImagesList, List<Datum> trendingList, Context context){
        this.trendingImagesList = trendingImagesList;
        this.trendingList = trendingList;
        this.context = context;
    }
    @Override
    public TrendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.list_item_trending, parent, false);

        return new TrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrendingViewHolder holder, int position) {

        try {
            imageUrl = trendingImagesList.get(position).getDownsized().getUrl();

            Glide.with(context)
                    .load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .placeholder(android.R.drawable.stat_notify_error)
                    .into(holder.gifStill);

        } catch (NullPointerException e){
            e.printStackTrace();
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                /* Open the URL of the image */
                String website = trendingList.get(pos).getUrl();
                Uri webpage = Uri.parse(website);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return trendingImagesList.size();
    }
}