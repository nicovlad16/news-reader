package com.nicoletavlad.newsreader.ui.main.feature.newslist.model.mapper;

import com.nicoletavlad.data.features.news.model.Article;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesToVMListMapper implements Function<List<Article>, List<ArticleItemViewModel>>
{

    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles)
    {
        List<ArticleItemViewModel> articlesViewModels = new ArrayList<>();

        for (Article article : articles)
        {
            ArticleItemViewModel articleItemViewModel = new ArticleItemViewModel(
                    article.title != null ? article.title : "",
                    article.content != null ? article.content : "",
                    article.imageUrl != null ? article.imageUrl : ""
            );

            articlesViewModels.add(articleItemViewModel);
        }

        return articlesViewModels;
    }

}
