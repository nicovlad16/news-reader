package com.nicoletavlad.newsreader.ui.main.feature.newslist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nicoletavlad.newsreader.databinding.NewsItemBinding;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.listener.NewsHandler;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>
{
    private List<ArticleItemViewModel> newsModelList;
    private NewsHandler handler;


    public NewsAdapter()
    {
        this.newsModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        NewsItemBinding binder = NewsItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false);

        return new ArticleViewHolder(binder);
    }


    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position)
    {
        holder.binding.setViewModel(newsModelList.get(position));
        holder.binding.setHandler(handler);
    }


    @Override
    public int getItemCount()
    {
        return newsModelList.size();
    }


    public void setItems(List<ArticleItemViewModel> items, NewsHandler handler)
    {
        this.handler = handler;
        this.newsModelList = items;
        notifyDataSetChanged();
    }


    public static class ArticleViewHolder extends RecyclerView.ViewHolder
    {
        final NewsItemBinding binding;


        public ArticleViewHolder(NewsItemBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}