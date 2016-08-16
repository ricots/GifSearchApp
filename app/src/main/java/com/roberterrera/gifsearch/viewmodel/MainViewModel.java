package com.roberterrera.gifsearch.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.roberterrera.gifsearch.model.service.GiphyFactory;
import com.roberterrera.gifsearch.model.trending.Datum;
import com.roberterrera.gifsearch.model.trending.Images;
import com.roberterrera.gifsearch.model.trending.TrendingResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rob on 8/12/16.
 */
public class MainViewModel implements ViewModel {

    private Context context;
    public List<Datum> trendingList;
    public List<Images> trendingListImages;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void getTrendingGifs() {
        GiphyFactory.create().getTrending().enqueue(new Callback<TrendingResponse>() {
            @Override
            public void onResponse(Call<TrendingResponse> call, Response<TrendingResponse> response) {

                if (response.isSuccessful()) {
                    try {
                        TrendingResponse responseBody = response.body();
                        trendingList = responseBody.getData();

                        for (int j = 0; j < trendingList.size(); j++) {

                            Images image = trendingList.get(j).getImages();
                            trendingListImages.add(image);
                        }
                    } catch (NoSuchMethodError e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<TrendingResponse> call, Throwable t) {
                Log.e("ONFAILURE", "API call failed.");
                t.printStackTrace();
            }
        });
    }

//TODO: make this call in the xml via data binding, but pass in the url of the image first.
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(android.R.drawable.stat_notify_error)
                .into(view);
    }

    @Override
    public void destroy() {
        context = null;
    }
}
