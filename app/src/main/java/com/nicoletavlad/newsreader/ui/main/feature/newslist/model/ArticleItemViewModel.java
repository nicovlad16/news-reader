package com.nicoletavlad.newsreader.ui.main.feature.newslist.model;

public class ArticleItemViewModel
{
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