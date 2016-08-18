package com.roberterrera.gifsearch.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.roberterrera.gifsearch.R;
import com.roberterrera.gifsearch.model.TrendingAdapter;
import com.roberterrera.gifsearch.model.service.GiphyFactory;
import com.roberterrera.gifsearch.model.trending.Datum;
import com.roberterrera.gifsearch.model.trending.Images;
import com.roberterrera.gifsearch.model.trending.TrendingResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public List<Images> trendingListImages;
    public TrendingAdapter mTrendingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Trending Gifs (powered by Giphy)");

        getTrendingGifs();

        mTrendingAdapter = new TrendingAdapter(trendingListImages, MainActivity.this);
        setUpMainRecyclerView(trendingListImages, mTrendingAdapter);

    }

    public void setUpMainRecyclerView(List<Images> trendingListImages, TrendingAdapter adapter) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_trending);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        if (trendingListImages != null) {
            Log.d("RECYCLERVIEW", "tempImages size: "+trendingListImages.size());

            if (recyclerView != null) {
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            } else {
                Log.d("RECYCLERVIEW", "No items to display.");
            }
        }
    }

    public void getTrendingGifs() {
        GiphyFactory.create().getTrending().enqueue(new Callback<TrendingResponse>() {
            @Override
            public void onResponse(Call<TrendingResponse> call, Response<TrendingResponse> response) {

                trendingListImages = new ArrayList<>();

                if (response.isSuccessful()) try {
                    TrendingResponse responseBody = response.body();
                    List<Datum> trendingList = responseBody.getData();
                    for (int j = 0; j < trendingList.size(); j++) {

                        Images image = trendingList.get(j).getImages();
                        trendingListImages.add(image);
                    }
                } catch (NoSuchMethodError e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TrendingResponse> call, Throwable t) {
                Log.e("ONFAILURE", "API call failed.");
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTrendingGifs();
        setUpMainRecyclerView(trendingListImages, mTrendingAdapter);
    }
}

