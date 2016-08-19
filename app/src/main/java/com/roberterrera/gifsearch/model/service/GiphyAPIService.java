package com.roberterrera.gifsearch.model.service;

import com.roberterrera.gifsearch.R;
import com.roberterrera.gifsearch.model.giphyapi.response.SearchResponse;
import com.roberterrera.gifsearch.model.giphyapi.response.TrendingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rob on 8/9/16.
 */

public interface GiphyAPIService {
    /* Because we are using the public API key it can go right in here,*/
    @GET("trending?fmt=json&rating=pg")
    Call<TrendingResponse> getTrending(@Query("api_key") String giphyKey);

    @GET("search?fmt=json&rating=pg")
    Call<SearchResponse> searchRequest(@Query("q") String query, @Query("api_key") String giphyKey);
}