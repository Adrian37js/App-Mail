package com.example.mymail.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mymail.Adapters.MailAdapter;
import com.example.mymail.Models.Mail;
import com.example.mymail.R;
import com.example.mymail.Utils.Util;

import java.util.List;

public class ListFragment extends Fragment {

    private MailAdapter adapter;
    private ListView listViewMails;
    private List<Mail> mails;

    private DataListener callback;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " se debe impelemementar DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        // Lógica para capturar los elementos de la UI
        listViewMails = (ListView) view.findViewById(R.id.listViewMails);
        mails = Util.getDummyData();
        adapter = new MailAdapter(getContext(), R.layout.fragment_list, mails);

        listViewMails.setAdapter(adapter);
        listViewMails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.onListClick(mails.get(position));
            }
        });

        return view;
    }

    public interface DataListener {
        void onListClick(Mail text);
    }
}