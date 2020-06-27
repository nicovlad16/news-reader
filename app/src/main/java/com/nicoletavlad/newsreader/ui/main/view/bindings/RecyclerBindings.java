package com.nicoletavlad.newsreader.ui.main.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nicoletavlad.newsreader.ui.main.feature.newslist.adapter.NewsAdapter;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.listener.NewsHandler;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings
{
    @BindingAdapter({"items", "newsHandler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles, NewsHandler handler)
    {
        NewsAdapter newsAdapter = (NewsAdapter) recyclerView.getAdapter();

        if (newsAdapter == null)
        {
            newsAdapter = new NewsAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(newsAdapter);
        }

        newsAdapter.setItems(articles, handler);
    }
}


