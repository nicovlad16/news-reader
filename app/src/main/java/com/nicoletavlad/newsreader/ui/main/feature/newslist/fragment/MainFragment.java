package com.nicoletavlad.newsreader.ui.main.feature.newslist.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nicoletavlad.newsreader.databinding.MainFragmentBinding;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.NewsListViewModel;

public class MainFragment extends Fragment
{
    private NewsListViewModel viewModel;


    public static MainFragment newInstance()
    {
        return new MainFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(requireActivity()).get(NewsListViewModel.class);
        getLifecycle().addObserver(viewModel);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        MainFragmentBinding binding = MainFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

}