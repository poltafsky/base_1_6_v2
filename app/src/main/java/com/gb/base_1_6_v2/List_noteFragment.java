package com.gb.base_1_6_v2;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class List_noteFragment extends Fragment {


    public static List_noteFragment newInstance() {
        List_noteFragment fragment = new List_noteFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String [] notes = getResources().getStringArray(R.array.List_notes);

        for (int i = 0; i < notes.length; i++){
            String noteName = notes[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(30f);
            textView.setText(noteName);
            ((LinearLayout) view).addView(textView);
            int finali= i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Note note = new Note(finali);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        Content_noteFragment content_noteFragment = Content_noteFragment.newInstance(note);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_note,content_noteFragment).commit();
                    } else {
                        Content_noteFragment content_noteFragment = Content_noteFragment.newInstance(note);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_note,content_noteFragment).addToBackStack("").commit();
                    }
                }
            });

        }
    }
}

