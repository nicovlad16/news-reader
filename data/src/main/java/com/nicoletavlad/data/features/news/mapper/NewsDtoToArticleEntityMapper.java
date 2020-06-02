package com.nicoletavlad.data.features.news.mapper;

import com.nicoletavlad.data.features.news.local.ArticleEntity;
import com.nicoletavlad.data.features.news.model.Article;
import com.nicoletavlad.data.features.news.remote.model.ArticleDto;
import com.nicoletavlad.data.features.news.remote.model.ArticleListDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsDtoToArticleEntityMapper implements Function<ArticleListDto, List<ArticleEntity>>
{

    @Override
    public List<ArticleEntity> apply(ArticleListDto articleDtos)
    {
        List<ArticleEntity> articles = new ArrayList<>();

        for (ArticleDto dto : articleDtos.articles)
        {
            ArticleEntity articleEntity = new ArticleEntity();

            articleEntity.setTitle(articleEntity.title);

            articleEntity.setImageUrl(articleEntity.imageUrl);

            articleEntity.setContent(articleEntity.content);

            articleEntity.setDescription(articleEntity.description);

            articles.add(articleEntity);
        }

        return articles;
    }
}
