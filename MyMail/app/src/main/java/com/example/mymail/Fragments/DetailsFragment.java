package com.example.mymail.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymail.Models.Mail;
import com.example.mymail.R;

public class DetailsFragment extends Fragment {

    //Atirbutos del mensaje al abrirlo
    private TextView asunto;
    private TextView remitente;
    private TextView mensaje;
    private LinearLayout wrapper; //El cotontorno del mensaje
    public DetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        //Cogemos los ID de fragment_detalis.xml
        asunto = (TextView) view.findViewById(R.id.textViewFragmentAsunto);
        remitente = (TextView) view.findViewById(R.id.textViewFragmentRemitente);
        mensaje = (TextView) view.findViewById(R.id.textViewFragmentMensaje);
        wrapper = (LinearLayout) view.findViewById(R.id.wrapper);
        wrapper.setVisibility(View.INVISIBLE);


        return view;
    }

    //Muestra el email
    public void renderMail(Mail mail) {
        wrapper.setVisibility(View.VISIBLE);
        asunto.setText(mail.getSubject());
        remitente.setText(mail.getSenderName());
        mensaje.setText(mail.getMessage());
    }
}