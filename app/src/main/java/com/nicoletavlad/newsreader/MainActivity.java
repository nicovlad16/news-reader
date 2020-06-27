package com.nicoletavlad.newsreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.nicoletavlad.newsreader.ui.main.feature.newslist.fragment.MainFragment;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.NewsListViewModel;
import com.nicoletavlad.newsreader.ui.main.feature.newslist.model.factory.ViewModelFactory;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}