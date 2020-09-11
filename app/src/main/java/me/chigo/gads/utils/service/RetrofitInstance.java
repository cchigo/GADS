package me.chigo.gads.utils.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;

    public void RetrofitInstance(){

    }

    /**
     * Create an instance of Retrofit object
     * */
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(100, TimeUnit.SECONDS);
            builder.readTimeout(100,TimeUnit.SECONDS);
            OkHttpClient okHttpClient = builder.build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(UrlConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
