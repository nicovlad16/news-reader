package com.nicoletavlad.newsreader.ui.main.feature.newslist.listener;

import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.ArticleItemViewModel;

public interface NewsHandler
{
    void onItemSelected(ArticleItemViewModel item);

    void onDeleteItemSelected(ArticleItemViewModel item);
}
