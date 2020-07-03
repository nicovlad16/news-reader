package com.nicoletavlad.data;

import com.nicoletavlad.data.features.news.local.NewsLocalDataSource;
import com.nicoletavlad.data.features.news.mapper.ArticleEntityToArticleMapper;
import com.nicoletavlad.data.features.news.mapper.ArticlesDtoToArticleEntityMapper;
import com.nicoletavlad.data.features.news.model.Article;
import com.nicoletavlad.data.features.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository
{
    private final NewsRemoteSource remoteSource;
    private final NewsLocalDataSource localSource;


    public NewsRepositoryImpl(NewsLocalDataSource localSource, NewsRemoteSource remoteSource)
    {
        this.localSource = localSource;
        this.remoteSource = remoteSource;
    }


    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles()
    {
        return remoteSource.getNewsArticles()
                .map(new ArticlesDtoToArticleEntityMapper())
                .doOnSuccess(localSource::saveItems)
                .onErrorResumeNext(localSource.getArticles())
                .map(new ArticleEntityToArticleMapper());
    }
}