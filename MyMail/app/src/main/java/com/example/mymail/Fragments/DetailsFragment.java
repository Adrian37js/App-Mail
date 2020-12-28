package com.example.mymail.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mymail.Models.Mail;
import com.example.mymail.R;

public class DetailsFragment extends Fragment {

    private TextView asunto;
    private TextView remitente;
    private TextView mensaje;

    private LinearLayout wrapper;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        asunto = (TextView) view.findViewById(R.id.textViewAsunto);
        remitente = (TextView) view.findViewById(R.id.textViewRemitente);
        mensaje = (TextView) view.findViewById(R.id.textViewMensaje);

        wrapper = (LinearLayout) view.findViewById(R.id.wrapper);

        // Inflate the layout for this fragment
        return view;
    }

    public void renderMail(Mail mail) {
        wrapper.setVisibility(View.VISIBLE);

        asunto.setText(mail.getSubject());
        remitente.setText(mail.getSenderName());
        mensaje.setText(mail.getMessage());

    }
}