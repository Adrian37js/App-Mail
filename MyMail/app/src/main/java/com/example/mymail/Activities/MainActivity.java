package com.example.mymail.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mymail.Fragments.ListFragment;
import com.example.mymail.Fragments.DetailsFragment;
import com.example.mymail.Models.Mail;
import com.example.mymail.R;

public class MainActivity extends AppCompatActivity implements ListFragment.DataListener {

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();
    }

    private void setMultiPanel() {
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }

    @Override
    public void onListClick(Mail mail) {

        if (isMultiPanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderMail(mail);

        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("asunto", mail.getSubject());
            intent.putExtra("remitente", mail.getSenderName());
            intent.putExtra("mensaje", mail.getMessage());
            startActivity(intent);
        }


    }
}