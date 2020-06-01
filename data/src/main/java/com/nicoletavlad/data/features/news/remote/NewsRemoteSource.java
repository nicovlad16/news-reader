package com.nicoletavlad.data.features.news.remote;

import com.nicoletavlad.data.features.news.remote.model.ArticleListDto;
import com.nicoletavlad.data.remote.NewsApi;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource
{

    private static final String API_KEY = "c27488624b304902be8936922381eb95";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;


    public NewsRemoteSource(NewsApi newsApi)
    {
        this.newsApi = newsApi;
    }


    public Single<ArticleListDto> getNewsArticles()
    {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io());
    }
}
