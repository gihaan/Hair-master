package com.example.mm.hair.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mm.hair.Fragment.DetailFragment;
import com.example.mm.hair.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.activity_detail,new DetailFragment()).commit();
        }
    }
}
