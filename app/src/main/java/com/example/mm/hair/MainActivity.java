package com.example.mm.hair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mm.hair.Fragment.FirstFragment;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.activity_main,new FirstFragment()).commit();

        }
    }


}
