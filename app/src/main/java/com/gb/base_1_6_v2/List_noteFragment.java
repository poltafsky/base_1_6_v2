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
    private Note currentNote;
    public static final String CURRENT_NOTE = "note_current";
    public static List_noteFragment newInstance() {
        List_noteFragment fragment = new List_noteFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_note, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_NOTE,currentNote);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState!=null) {
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE);
        }else {
            currentNote = new Note(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showLand();
        }

            initView(view);

    }

    private void initView(View view) {
        String[] notes = getResources().getStringArray(R.array.List_notes);

        for (int i = 0; i < notes.length; i++) {
            String noteName = notes[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(30f);
            textView.setText(noteName);
            ((LinearLayout) view).addView(textView);
            int finali = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentNote = new Note(finali);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        showLand ();
                    } else {
                        showPort();
                    }

                }
            });

        }
    }

    private void showLand () {
        Content_noteFragment content_noteFragment = Content_noteFragment.newInstance(currentNote);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_note, content_noteFragment).commit();
    }
    private void showPort () {
        Content_noteFragment content_noteFragment = Content_noteFragment.newInstance(currentNote);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_note, content_noteFragment).addToBackStack("").commit();
    }
}

