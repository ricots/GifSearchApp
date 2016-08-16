package com.roberterrera.gifsearch.model;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roberterrera.gifsearch.R;
import com.roberterrera.gifsearch.databinding.ListItemTrendingBinding;
import com.roberterrera.gifsearch.model.trending.Images;

import java.util.List;

/**
 * Created by Rob on 8/16/16.
 */
public class TrendingAdapter extends RecyclerView.Adapter<TrendingViewHolder> {

    private final List<Images> trendingImagesList;

    public TrendingAdapter(List<Images> trendingList){
        this.trendingImagesList = trendingList;
    }

    @Override
    public TrendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemTrendingBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.list_item_trending, parent, false);
        return new TrendingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TrendingViewHolder holder, int position) {

//        try {
//            String imageUrl = trendingImagesList.get(position).getFixedWidthStill().getUrl();
//            Picasso.with(holder.gifStill.getContext())
//                    .load(imageUrl)
//                    .placeholder(android.R.drawable.stat_notify_error)
//                    .into(holder.gifStill);
//        } catch (NullPointerException e){
//            e.printStackTrace();
//        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
//                Toast.makeText(context, trendingListImages.get(pos).getUrl(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return trendingImagesList.size();
    }
}