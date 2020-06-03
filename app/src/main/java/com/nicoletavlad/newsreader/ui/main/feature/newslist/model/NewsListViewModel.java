package com.nicoletavlad.newsreader.ui.main.feature.newslist.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.nicoletavlad.data.NewsRepository;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.listener.NewsHandler;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.mapper.ArticlesToVMListMapper;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver, NewsHandler
{
    private final static String LINK = "https://newsapi.org/";
    public final ObservableBoolean isLoading;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;
    private final NewsRepository repository;
    @NonNull
    public ObservableList<ArticleItemViewModel> newsList;


    public NewsListViewModel(Application application, NewsRepository repository)
    {
        super(application);
        this.repository = repository;
        newsList = new ObservableArrayList();
        isLoading = new ObservableBoolean();
        error = new SingleLiveEvent<>();
        openLink = new SingleLiveEvent<>();
    }


    //    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    public void refresh()
//    {
//        if (newsList.isEmpty())
//        {
//            ArticleItemViewModel item = new ArticleItemViewModel("title", "content",
//                    "https://images.unsplash.com/photo-1497250681960-ef046c08a56e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=60");
//            newsList.add(item);
//
//            item = new ArticleItemViewModel("news title", "news content",
//                    "https://cdn.pixabay.com/photo/2019/05/05/21/45/forget-me-not-4181791_960_720.jpg");
//            newsList.add(item);
//
//            item = new ArticleItemViewModel("news", "content",
//                    "https://www.dw.com/image/45348566_303.jpg");
//            newsList.add(item);
//        }
//    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @SuppressLint("CheckResult")
    public void refresh()
    {
        repository.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }


    private void onNewsArticlesError(Throwable throwable)
    {

        isLoading.set(false);
        error.setValue(throwable);
    }


    private void onNewsArticlesReceived(List<ArticleItemViewModel> articles)
    {
        isLoading.set(false);
        newsList.addAll(articles);
    }


    public void onPoweredBySelected()
    {
        openLink.setValue(LINK);
    }
}
