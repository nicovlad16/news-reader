package com.nicoletavlad.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.nicoletavlad.data.features.news.local.ArticleDao;
import com.nicoletavlad.data.features.news.local.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase
{
    public abstract ArticleDao articleDao();
}