package com.nicoletavlad.data.features.news.mapper;

import com.nicoletavlad.data.features.news.local.ArticleEntity;
import com.nicoletavlad.data.features.news.remote.model.ArticleDto;
import com.nicoletavlad.data.features.news.remote.model.ArticlesDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesDtoToArticleEntityMapper implements Function<ArticlesDto, List<ArticleEntity>>
{
    @Override
    public List<ArticleEntity> apply(ArticlesDto articleDtos)
    {
        List<ArticleEntity> articles = new ArrayList<>();

        for (ArticleDto articleDto : articleDtos.articles)
        {
            ArticleEntity articleEntity = new ArticleEntity();

            articleEntity.setTitle(articleDto.title);
            articleEntity.setImageUrl(articleDto.urlToImage);
            articleEntity.setContent(articleDto.content);
            articleEntity.setDescription(articleDto.description);

            articles.add(articleEntity);
        }

        return articles;
    }
}