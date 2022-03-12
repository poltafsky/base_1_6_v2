package com.gb.base_1_6_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Content_noteFragment extends Fragment {
    public static final String ARG_NOTE = "note";

    private Note note;
    public static Content_noteFragment newInstance(Note note) {
        Content_noteFragment fragment = new Content_noteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE,note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        note = getArguments().getParcelable(ARG_NOTE);
        TextView textView= view.findViewById(R.id.nameNotes);
        textView.setText(note.getIndex());

        //String [] note = getResources().getStringArray(R.array.List_notes);
       // ((TextView) view.findViewById(R.id.nameNotes)).setText(note[note.getIndex()]);
    }
}