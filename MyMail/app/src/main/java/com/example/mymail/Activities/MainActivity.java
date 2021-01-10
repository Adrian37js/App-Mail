package com.example.mymail.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mymail.Fragments.ListFragment;
import com.example.mymail.Fragments.DetailsFragment;
import com.example.mymail.Models.Mail;
import com.example.mymail.R;

public class MainActivity extends AppCompatActivity implements ListFragment.DataListener {

    //Declaramos un multipanel
    private boolean MultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Le mandamos al metodo setMultiPanel
        setMultiPanel();
    }

    private void setMultiPanel() {
        MultiPanel = (getSupportFragmentManager().findFragmentById(R.id.fragmentDetails) != null);
    }

    @Override
    public void onListClick(Mail mail) {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetails);

        //En este if comprobamos si sirve para moviles o para tablets
        if (MultiPanel) {
            detailsFragment.renderMail(mail);
        } else {
            //Pasamos con el Intent los datos del Main al DetailsAtivity
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("asunto", mail.getSubject());
            intent.putExtra("remitente", mail.getSenderName());
            intent.putExtra("mensaje", mail.getMessage());

            startActivity(intent);
        }
    }
}