package com.nicoletavlad.newsreader.ui.main.feature.newslist.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.nicoletavlad.newsreader.ui.main.feature.newslist.listener.NewsHandler;


public class NewsListViewModel extends ViewModel implements LifecycleObserver, NewsHandler
{
    @NonNull
    public ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList();


    @Override
    public void onItemSelected(ArticleItemViewModel item)
    {
    }


    @Override
    public void onDeleteItemSelected(ArticleItemViewModel item)
    {

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh()
    {
        if (newsList.isEmpty())
        {
            ArticleItemViewModel item = new ArticleItemViewModel("title", "content",
                    "https://images.unsplash.com/photo-1497250681960-ef046c08a56e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=60");
            newsList.add(item);

            item = new ArticleItemViewModel("news title", "news content",
                    "https://cdn.pixabay.com/photo/2019/05/05/21/45/forget-me-not-4181791_960_720.jpg");
            newsList.add(item);

            item = new ArticleItemViewModel("news", "content",
                    "https://www.dw.com/image/45348566_303.jpg");
            newsList.add(item);
        }
    }
}
