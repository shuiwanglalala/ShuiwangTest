package com.example.shuiwangtest.okhtp;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.orhanobut.logger.Logger.VERBOSE;

public class GetExample {
  private static final String TAG = "GetExample";
  OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(new LoggingInterceptor.Builder()
                  .setLevel(Level.BASIC)
                  .log(VERBOSE)
                  .build())
          .build();

  String run(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }

  public static void main(String[] args) throws IOException {
    GetExample example = new GetExample();
    String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
//    System.out.println(response);
    Logger.d(response);
  }
}
