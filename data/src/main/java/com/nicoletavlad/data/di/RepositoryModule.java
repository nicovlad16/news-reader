package com.nicoletavlad.data.di;

import android.app.Application;
import android.content.Context;

import com.nicoletavlad.data.NewsRepository;
import com.nicoletavlad.data.NewsRepositoryImpl;
import com.nicoletavlad.data.features.news.remote.NewsRemoteSource;
import com.nicoletavlad.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepositoryModule
{
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;


    public RepositoryModule(@NonNull Application application)
    {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }


    public NewsRepository provideNewsRepository()
    {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }


    private NewsRemoteSource provideNewsRemoteSource()
    {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
