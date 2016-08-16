package com.roberterrera.gifsearch.model.service;

import com.roberterrera.gifsearch.model.trending.TrendingResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rob on 8/15/16.
 */
public class GiphyFactory {

    private final GiphyAPIService networkService;
    public static String baseUrl = "http://api.giphy.com/v1/gifs/";

    public static GiphyAPIService create() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client)
                .build();

        return retrofit.create(GiphyAPIService.class);
    }

    public GiphyFactory(GiphyAPIService networkService) {
        this.networkService = networkService;
    }

//    public Subscription getTrendingList(final GetTrendingCallback callback) {
//
//        return networkService.getTrending()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .onErrorResumeNext(new Func1<Throwable, Observable<? extends TrendingResponse>>() {
//                    @Override
//                    public Observable<? extends TrendingResponse> call(Throwable throwable) {
//                        return Observable.error(throwable);
//                    }
//                })
//                .subscribe(new Subscriber<TrendingResponse>() {
//                    @Override
//                    public void onCompleted() {}
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(TrendingResponse response) {
//                        callback.onSuccess(response);
//                    }
//                });
//    }

    public interface GetTrendingCallback{
        void onSuccess(TrendingResponse response);
        void onError();
    }
}