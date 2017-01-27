package com.example.mm.hair.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mm.hair.Fragment.NewMethodFragment;
import com.example.mm.hair.R;

public class NewMethod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_method);
        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.activity_new_method,new NewMethodFragment()).commit();
        }
    }
}
