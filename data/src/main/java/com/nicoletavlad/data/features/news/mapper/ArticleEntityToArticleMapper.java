package com.nicoletavlad.data.features.news.mapper;

import com.nicoletavlad.data.features.news.local.ArticleEntity;
import com.nicoletavlad.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntityToArticleMapper implements Function<List<ArticleEntity>, List<Article>>
{
    @Override
    public List<Article> apply(List<ArticleEntity> articleEntities)
    {
        List<Article> articles = new ArrayList<>();

        for (ArticleEntity articleEntity : articleEntities)
        {
            Article article = new Article(
                    articleEntity.imageUrl != null ? articleEntity.imageUrl : "",
                    articleEntity.title != null ? articleEntity.title : "",
                    articleEntity.content != null ? articleEntity.content : "",
                    articleEntity.description != null ? articleEntity.description : ""
            );

            articles.add(article);
        }

        return articles;
    }
}