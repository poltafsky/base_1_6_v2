package com.gb.base_1_6_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MyFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);

         if(savedInstanceState==null){
             List_noteFragment list_noteFragment = List_noteFragment.newInstance();
             getSupportFragmentManager().beginTransaction().replace(R.id.list_note,list_noteFragment).commit();
             if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                 Note default_note = new Note("Note #1", R.array.notes_description);
                 Content_noteFragment content_noteFragment = Content_noteFragment.newInstance(default_note);
                 getSupportFragmentManager().beginTransaction().replace(R.id.content_note,content_noteFragment).commit();
             }
         }
    }
}