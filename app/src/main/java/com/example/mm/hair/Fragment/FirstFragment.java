package com.example.mm.hair.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mm.hair.Activity.NewMethod;
import com.example.mm.hair.Activity.SecondActivity;
import com.example.mm.hair.Data.DataVariable;
import com.example.mm.hair.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 06/01/2017.
 */

public class FirstFragment extends Fragment {

    List<DataVariable> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override



    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.favourite) {

            Intent intent = new Intent(getContext(),SecondActivity.class);
            String select="select";

            Bundle bundle=new Bundle();
            bundle.putString("favourite", select);
            intent.putExtras(bundle);
            startActivity(intent);


            /*
            Intent intent = new Intent(getContext(), DetailActivity.class);
                Bundle bundle=new Bundle();

                DataVariable data=(DataVariable) getmList().get(i);
                bundle.putSerializable("datarow",data);
                intent.putExtras(bundle);
                startActivity(intent);

             */

            return true;
        }

        if (id == R.id.addmethod) {

            Intent intent = new Intent(getContext(), NewMethod.class);
            startActivity(intent);


            return true;
        }

        return true;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first, container, false);
        ImageButton imbutFirst = (ImageButton) view.findViewById(R.id.imbut_first);
        TextView etTitle = (TextView) view.findViewById(R.id.tv_title);
        imbutFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SecondActivity.class);
                startActivity(intent);

            }
        });


        return view;


    }
}
