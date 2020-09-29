package me.chigo.gads.utils.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import me.chigo.gads.utils.UrlConstants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class SubmitRetrofitInstance {
    private static Retrofit retrofit;

    public void SubmitRetrofitInstance(){

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
                    .baseUrl(UrlConstants.SUBMISSION_BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
