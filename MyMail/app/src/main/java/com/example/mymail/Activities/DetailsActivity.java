package com.example.mymail.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymail.Fragments.DetailsFragment;
import com.example.mymail.Models.Mail;
import com.example.mymail.R;

public class DetailsActivity extends AppCompatActivity {

    private String asunto;
    private String mensaje;
    private String remitente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().getExtras() != null){
            asunto = getIntent().getStringExtra("asunto");
            remitente = getIntent().getStringExtra("remitente");
            mensaje = getIntent().getStringExtra("mensaje");
        }

        Mail mail = new Mail(asunto, remitente, mensaje);

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailsMail);
        detailsFragment.renderMail(mail);
    }

}
