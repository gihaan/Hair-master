package com.example.mm.hair.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mm.hair.Fragment.SecodFragment;
import com.example.mm.hair.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.activity_second,new SecodFragment()).commit();
        }



    }
}
