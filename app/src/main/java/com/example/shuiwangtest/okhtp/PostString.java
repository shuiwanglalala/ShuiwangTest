/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.shuiwangtest.okhtp;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.orhanobut.logger.Logger.VERBOSE;

public final class PostString {
  public static final MediaType MEDIA_TYPE_MARKDOWN
      = MediaType.get("text/x-markdown; charset=utf-8");

  OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(new LoggingInterceptor.Builder()
                  .setLevel(Level.BASIC)
                  .log(VERBOSE)
                  .build())
          .build();

  public void run() throws Exception {
    String postBody = ""
        + "Releases\n"
        + "--------\n"
        + "\n"
        + " * _1.0_ May 6, 2013\n"
        + " * _1.1_ June 15, 2013\n"
        + " * _1.2_ August 11, 2013\n";

    Request request = new Request.Builder()
        .url("https://api.github.com/markdown/raw")
        .post(RequestBody.create(postBody, MEDIA_TYPE_MARKDOWN))
        .build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

      System.out.println(response.body().string());
    }
  }

  public static void main(String... args) throws Exception {
    new PostString().run();
  }
}
