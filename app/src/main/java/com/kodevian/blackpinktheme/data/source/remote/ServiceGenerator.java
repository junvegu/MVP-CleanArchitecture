package com.kodevian.blackpinktheme.data.source.remote;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kodevian.blackpinktheme.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String API_BASE_URL = BuildConfig.BASE;

    private static Retrofit retrofit;

    @NonNull
    private static Gson mGson = new GsonBuilder()
            .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
            .create();

    @NonNull
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(mGson));

    @NonNull
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    @NonNull
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(@NonNull Class<S> serviceClass) {

        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        retrofit = builder.client(httpClient.build()).build();

        return retrofit.create(serviceClass);
    }

    /**
     * or Error Handing when non-OK response is received from Server
     */
    @NonNull
    public static Retrofit retrofit() {
        OkHttpClient client = httpClient.build();
        ;
        return builder.client(client).build();
    }

}