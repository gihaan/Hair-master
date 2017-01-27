package com.example.mm.hair.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mm.hair.Activity.DetailActivity;
import com.example.mm.hair.Data.DataVariable;
import com.example.mm.hair.Data.DatabaseOperation;
import com.example.mm.hair.Data.FavouriteOperation;
import com.example.mm.hair.Data.ListAdapter;
import com.example.mm.hair.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 08/01/2017.
 */

public class SecodFragment extends Fragment {
    private ListAdapter adapter;
    private List<DataVariable> mList;
    int Flag = 0;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_list_view, container, false);
        ListView listView = (ListView) view.findViewById(R.id.main_list_view);


        Intent intent = new Intent(getContext(), DetailActivity.class);
        Bundle bundle = intent.getExtras();

        if (bundle == null) {
            bundle = getActivity().getIntent().getExtras();
            mList = getmList();

        }
//        String y=bundle.getString("favourite");
//        if (y != "select") {

            mList=getmList();


        adapter = new ListAdapter(this.getContext(), mList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                Bundle bundle = new Bundle();

                DataVariable data = (DataVariable) mList.get(i);
                bundle.putSerializable("datarow", data);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });


        return view;
    }

    public List<DataVariable> getmList() {
        DatabaseOperation databaseOperation = new DatabaseOperation(getContext());
        mList = new ArrayList<>();
        Cursor cr = databaseOperation.getInformation(databaseOperation);
        cr.moveToFirst();
        while ((cr.moveToNext())) {
            DataVariable dataVariable = new DataVariable();
            dataVariable.setTitle(cr.getString(0));
            dataVariable.setComponent(cr.getString(1));
            dataVariable.setMethod(cr.getString(2));
            mList.add(dataVariable);


        }
        return mList;

    }

    public List<DataVariable> getmFavouriteList() {
        FavouriteOperation databaseOperation = new FavouriteOperation(getContext());
        mList = new ArrayList<>();
        Cursor cr = databaseOperation.getInformation(databaseOperation);
        cr.moveToFirst();
        while ((cr.moveToNext())) {
            DataVariable dataVariable = new DataVariable();
            dataVariable.setTitle(cr.getString(0));
            dataVariable.setComponent(cr.getString(1));
            dataVariable.setMethod(cr.getString(2));
            mList.add(dataVariable);


        }
        return mList;

    }






}
