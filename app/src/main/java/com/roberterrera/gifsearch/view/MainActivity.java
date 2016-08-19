package com.roberterrera.gifsearch.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
    private TrendingAdapter mTrendingAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Trending Gifs (powered by Giphy)");

        trendingListImages = new ArrayList<>();

        mTrendingAdapter = new TrendingAdapter(trendingListImages, MainActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_trending);
    }

    public void setUpMainRecyclerView(List<Images> list, TrendingAdapter adapter) {

        if (list != null) {

            if (recyclerView != null) {
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(
                        3,StaggeredGridLayoutManager.VERTICAL));
            } else {
                Log.e("RECYCLERVIEW", "Cannot display items.");
            }
        } Log.e("RECYCLERVIEW", "List is null.");

    }

    public void getTrendingGifs() {
        GiphyFactory.create().getTrending().enqueue(new Callback<TrendingResponse>() {
            @Override
            public void onResponse(Call<TrendingResponse> call, Response<TrendingResponse> response) {


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

