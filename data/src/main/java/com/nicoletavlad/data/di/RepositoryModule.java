package com.nicoletavlad.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.nicoletavlad.data.NewsRepository;
import com.nicoletavlad.data.NewsRepositoryImpl;
import com.nicoletavlad.data.features.news.local.NewsLocalDataSource;
import com.nicoletavlad.data.features.news.remote.NewsRemoteSource;
import com.nicoletavlad.data.remote.HttpClientFactory;
import com.nicoletavlad.data.store.local.NewsDatabase;

import io.reactivex.annotations.NonNull;

public class RepositoryModule
{
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    private volatile NewsDatabase database;


    public RepositoryModule(@NonNull Application application)
    {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }


    public NewsRepository provideNewsRepository()
    {
        return new NewsRepositoryImpl(provideNewsLocalDataSource(), provideNewsRemoteSource());
    }


    private NewsRemoteSource provideNewsRemoteSource()
    {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }


    NewsLocalDataSource provideNewsLocalDataSource()
    {
        NewsDatabase database = getInstance();
        return new NewsLocalDataSource(database.articleDao());
    }


    private NewsDatabase getInstance()
    {
        if (database == null)
        {
            synchronized (NewsDatabase.class)
            {
                if (database == null)
                {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "news.db")
                            .build();
                }
            }
        }
        return database;
    }
}