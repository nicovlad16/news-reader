package com.nicoletavlad.newsreader.ui.main.feature.newslist.model.factory;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.nicoletavlad.data.NewsRepository;
import com.nicoletavlad.newsreader.StartApplication;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.NewsListViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            NewsRepository repository = StartApplication.getRepositoryProvider().provideNewsRepository();
            return (T) new NewsListViewModel(application, repository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class.");
    }
}