package com.example.mm.hair.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mm.hair.Data.DataVariable;
import com.example.mm.hair.Data.DatabaseOperation;
import com.example.mm.hair.R;

/**
 * Created by mm on 09/01/2017.
 */

public class NewMethodFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    TextView tv_newMetho;
    TextView tv_newComponent;
    EditText et_title;
    EditText et_newMethod;
    EditText et_newComponent;
     DataVariable dv=new DataVariable();
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.new_method,container,false);

         tv_newMetho= (TextView) view.findViewById(R.id.tv_method);
       tv_newComponent=(TextView)view.findViewById(R.id.tv_component);
         et_title=(EditText) view.findViewById(R.id.et_title);
        et_newMethod=(EditText)view.findViewById(R.id.et_new_method);
         et_newComponent=(EditText)view.findViewById(R.id.et_new_component);
        Button btn_addNewMethod=(Button)view.findViewById(R.id.bt_add_new_method);


        btn_addNewMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dv.setTitle(et_title.getText().toString());
                dv.setComponent(et_newComponent.getText().toString());
                dv.setMethod(et_newMethod.getText().toString());


                DatabaseOperation ob = new DatabaseOperation(getContext());
                ob.inputInformation(dv);

                Toast.makeText(getActivity(), "  ADD NEW METHOD IS SUCCESSFULL", Toast.LENGTH_SHORT).show();
            }
        });




        return view;
    }
}
