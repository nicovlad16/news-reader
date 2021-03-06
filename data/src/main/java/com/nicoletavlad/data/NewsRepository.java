package com.nicoletavlad.data;


import com.nicoletavlad.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public interface NewsRepository
{
    @NonNull
    Single<List<Article>> getNewsArticles();
}