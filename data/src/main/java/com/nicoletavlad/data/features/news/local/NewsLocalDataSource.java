package com.nicoletavlad.data.features.news.local;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class NewsLocalDataSource
{
    private ArticleDao dao;


    public NewsLocalDataSource(ArticleDao dao)
    {
        this.dao = dao;
    }


    public Flowable<List<ArticleEntity>> getArticles()
    {

        return dao.queryArticles();
    }


    public Single<List<ArticleEntity>> saveItems(final List<ArticleEntity> list)
    {
        return Single.create(emitter ->
        {
            dao.insertArticles(list);
            emitter.onSuccess(list);
        });
    }
}
