package com.example.mymail.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListFragment;
import android.os.Bundle;

import com.example.mymail.Fragments.DataFragment;
import com.example.mymail.Fragments.DetailsFragment;
import com.example.mymail.R;

public class MainActivity extends AppCompatActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(String text) {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);
    }
}