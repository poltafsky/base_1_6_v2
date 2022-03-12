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
             List_noteFragment list_noteFragment = new List_noteFragment();
             getSupportFragmentManager().beginTransaction().replace(R.id.list_note,list_noteFragment).commit();
             if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                 Content_noteFragment content_noteFragment = new Content_noteFragment();
                 getSupportFragmentManager().beginTransaction().replace(R.id.content_note,content_noteFragment).commit();
             }
         }
    }
}