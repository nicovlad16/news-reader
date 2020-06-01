package com.nicoletavlad.newsreader.ui.main.feature.newslist.navigator;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;

import com.nicoletavlad.data.remote.exception.ApiException;
import com.nicoletavlad.data.remote.exception.ConnectivityException;
import com.nicoletavlad.newsreader.R;

import io.reactivex.annotations.NonNull;

public class AlertNavigator
{

    private final FragmentManager fragmentManager;
    private final Context context;


    public AlertNavigator(@NonNull FragmentManager fragmentManager, @NonNull Context context)
    {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }


    public void showErrorFor(@NonNull Throwable throwable)
    {
        if (throwable instanceof ConnectivityException || throwable instanceof ApiException)
        {
            showAlert(context.getString(R.string.network_error, throwable.getMessage()));
        }
    }


    public void showAlert(@NonNull String message)
    {
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.error_title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, (dialogInterface, i) ->
                {
                })
                .show();
    }
}

