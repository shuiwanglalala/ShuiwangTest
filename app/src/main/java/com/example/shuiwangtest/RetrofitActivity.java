package com.example.shuiwangtest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shuiwangtest.retrofit.GitHubClient;
import com.example.shuiwangtest.retrofit.GitHubRepo;
import com.example.shuiwangtest.retrofit.ServiceGenerator;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.orhanobut.logger.Logger.VERBOSE;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });


    }

    private void request() {
        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);
        Call<List<GitHubRepo>> call = client.reposForUser("shuiwanglalala");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });
    }

}
