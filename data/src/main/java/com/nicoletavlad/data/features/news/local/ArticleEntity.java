package com.nicoletavlad.data.features.news.local;


import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity
{
    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String title;

    public String description;

    public String imageUrl;

    public String content;


    public void setTitle(String title)
    {
        this.title = title;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }


    public void setContent(String content)
    {
        this.content = content;
    }
}
