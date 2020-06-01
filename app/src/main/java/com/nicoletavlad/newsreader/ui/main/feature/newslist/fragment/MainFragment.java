package com.nicoletavlad.newsreader.ui.main.feature.newslist.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nicoletavlad.newsreader.databinding.MainFragmentBinding;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.NewsListViewModel;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.factory.ViewModelFactory;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.navigator.AlertNavigator;

public class MainFragment extends Fragment
{
    private NewsListViewModel viewModel;
    private AlertNavigator alertNavigator;


    public static MainFragment newInstance()
    {
        return new MainFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        alertNavigator = new AlertNavigator(getChildFragmentManager(), requireContext());

        viewModel = new ViewModelProvider(this,
                new ViewModelFactory(requireActivity().getApplication())).get(NewsListViewModel.class);
        viewModel.error.observe(this, throwable -> alertNavigator.showErrorFor(throwable));
        viewModel.openLink.observe(this, this::openLink);
        getLifecycle().addObserver(viewModel);
    }


    private void openLink(@NonNull String link)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
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