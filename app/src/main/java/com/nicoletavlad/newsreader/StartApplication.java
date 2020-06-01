package com.nicoletavlad.newsreader;

import android.app.Application;

import com.nicoletavlad.data.di.RepositoryModule;

public class StartApplication extends Application
{
    private static RepositoryModule repositoryModule;


    @Override
    public void onCreate()
    {
        super.onCreate();
        repositoryModule = new RepositoryModule(this);
    }


    public static RepositoryModule getRepositoryProvider()
    {
        return repositoryModule;
    }
}