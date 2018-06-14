package com.example.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Виталина on 19.08.2017.
 */

public interface INews_Api {
    @GET("articles")
    Call<NewsResponse> getNews (@Query("source") String source,@Query("apiKey") String key );

}
