package com.roberterrera.gifsearch.model.service;

import com.roberterrera.gifsearch.model.search.SearchResponse;
import com.roberterrera.gifsearch.model.trending.TrendingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rob on 8/9/16.
 */

public interface GiphyAPIService {
    /* Trending: returns a max of 25 results */
    /* Because we are using the public API key it can go right in here,*/
    @GET("trending?rating=pg&fmt=json&api_key=dc6zaTOxFJmzC")
    Call<TrendingResponse> getTrending();

    @GET("search?fmt=json&rating=pg&api_key=dc6zaTOxFJmzC")
    Call<SearchResponse> searchRequest(@Query("q") String query);
}