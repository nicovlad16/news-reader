package com.nicoletavlad.newsreader.ui.main.feature.newslist.model;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel
{
    @Nullable
    public Integer id;
    public final String title;
    public final String content;
    public final String image;


    public ArticleItemViewModel(String title, String content, String image)
    {
        this.title = title;
        this.content = content;
        this.image = image;
    }
}
