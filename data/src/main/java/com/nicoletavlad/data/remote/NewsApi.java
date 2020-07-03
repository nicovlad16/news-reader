package com.nicoletavlad.data.remote;


import com.nicoletavlad.data.features.news.remote.model.ArticlesDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi
{
    @GET("/v2/top-headlines")
    Single<ArticlesDto> getNewsArticles(@Query("apiKey") String apiKey, @Query("language") String language);
}