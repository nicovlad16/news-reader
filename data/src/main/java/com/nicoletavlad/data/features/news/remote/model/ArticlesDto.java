package com.nicoletavlad.data.features.news.remote.model;

import java.util.List;

public class ArticlesDto
{
    public final int totalResults;
    public final List<ArticleDto> articles;


    ArticlesDto(int totalResults, List<ArticleDto> articles)
    {
        this.totalResults = totalResults;
        this.articles = articles;
    }
}