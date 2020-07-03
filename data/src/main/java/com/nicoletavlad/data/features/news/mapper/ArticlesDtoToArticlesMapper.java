package com.nicoletavlad.data.features.news.mapper;

import com.nicoletavlad.data.features.news.model.Article;
import com.nicoletavlad.data.features.news.remote.model.ArticleDto;
import com.nicoletavlad.data.features.news.remote.model.ArticlesDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesDtoToArticlesMapper implements Function<ArticlesDto, List<Article>>
{

    @Override
    public List<Article> apply(ArticlesDto articleDtos)
    {
        List<Article> articles = new ArrayList<>();

        for (ArticleDto dto : articleDtos.articles)
        {
            Article article = new Article(
                    dto.urlToImage != null ? dto.urlToImage : "",
                    dto.title != null ? dto.title : "",
                    dto.content != null ? dto.content : "",
                    dto.description != null ? dto.description : ""
            );

            articles.add(article);
        }

        return articles;
    }
}