package com.nicoletavlad.newsreader;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nicoletavlad.newsreader.ui.main.feature.newslist.fragment.MainFragment;

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