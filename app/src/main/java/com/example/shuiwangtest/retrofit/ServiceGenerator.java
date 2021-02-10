package com.example.shuiwangtest.retrofit;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.orhanobut.logger.Logger.VERBOSE;

public class ServiceGenerator {
    private static final String BASE_URL = "https://api.github.com/";

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor.Builder()
                    .setLevel(Level.BASIC)
                    .log(VERBOSE)
                    .build());

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();


    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
