package com.example.mm.hair.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mm.hair.Activity.DetailActivity;
import com.example.mm.hair.Data.DataVariable;
import com.example.mm.hair.Data.FavouriteOperation;
import com.example.mm.hair.R;

/**
 * Created by mm on 08/01/2017.
 */

public class DetailFragment extends Fragment {


    DataVariable dv=new DataVariable();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail, container, false);

        ImageView main_pic=(ImageView)view.findViewById(R.id.iv_main_picture);
        ImageView imv_favourite=(ImageView)view.findViewById(R.id.imb_favourite_button);
        TextView tv_component=(TextView)view.findViewById(R.id.tv_component);
        TextView tv_method=(TextView)view.findViewById(R.id.tv_method);
        final TextView et_method=(TextView)view.findViewById(R.id.et_method);
        final TextView et_component=(TextView)view.findViewById(R.id.et_component);
////////////////////////////////////////////////////////////////////////////////////
        Intent intent = new Intent(getContext(), DetailActivity.class);
        Bundle bundle=intent.getExtras();

        if (bundle == null) {
            bundle = getActivity().getIntent().getExtras();
        }
         final DataVariable data=(DataVariable)bundle.getSerializable("datarow");
        final String title=data.getTitle();
        et_method.setText(data.getMethod());
        et_component.setText(data.getComponent());
///////////////////////////////////////////////////////////////////////////////////////////

        imv_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dv.setTitle(title);
                dv.setComponent(et_component.getText().toString());
                dv.setMethod(et_method.getText().toString());


                FavouriteOperation ob = new FavouriteOperation(getContext());
                ob.inputInformation(dv);

                Toast.makeText(getActivity(), "  ADD NEW FAOURITE IS SUCCESSFULL", Toast.LENGTH_SHORT).show();

            }
        });




        return view;

    }
}
