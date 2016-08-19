package com.roberterrera.gifsearch.model.adapter;

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
import com.roberterrera.gifsearch.model.giphyapi.Images;

import java.util.List;

/**
 * Created by Rob on 8/19/16.
 */
public class SearchAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Images> searchResultsImages;

    private Context context;

    public SearchAdapter(List<Images> searchResultsImages, Context context){
        this.searchResultsImages = searchResultsImages;
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
            String imageUrl = searchResultsImages.get(position).getFixedWidth().getUrl();

            Glide.with(context)
                    .load(imageUrl)
                    .asGif()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(android.R.drawable.stat_notify_error)
                    .into(holder.gifStill);

        } catch (NullPointerException e){
            e.printStackTrace();
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                /* Open the URL of the image */
                String website = searchResultsImages.get(pos).getFixedWidth().getUrl();
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
        return searchResultsImages.size();
    }
}