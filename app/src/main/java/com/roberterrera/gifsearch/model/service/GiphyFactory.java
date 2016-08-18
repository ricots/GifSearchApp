package com.roberterrera.gifsearch.model.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rob on 8/15/16.
 */
public class GiphyFactory {

    public static String baseUrl = "http://api.giphy.com/v1/gifs/";

    public static GiphyAPIService create() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client)
                .build();

        return retrofit.create(GiphyAPIService.class);
    }
}