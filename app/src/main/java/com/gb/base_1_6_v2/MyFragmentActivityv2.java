package com.gb.base_1_6_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

public class MyFragmentActivityv2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);

         if(savedInstanceState==null){
             List_noteFragment list_noteFragment = List_noteFragment.newInstance();
             getSupportFragmentManager().beginTransaction().replace(R.id.list_note,list_noteFragment).commit();

         }
    }
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment)getSupportFragmentManager().findFragmentById(R.id.list_note);

        if (backStackFragment!=null&&backStackFragment instanceof Content_noteFragment){
            //сэмулируем нажатие кнопки назад
            onBackPressed();
        }
    }
}
