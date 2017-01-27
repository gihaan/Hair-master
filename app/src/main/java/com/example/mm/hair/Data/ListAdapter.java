package com.example.mm.hair.Data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mm.hair.R;

import java.util.List;

/**
 * Created by mm on 08/01/2017.
 */

public class ListAdapter extends BaseAdapter {


    private Context context;
    private List<DataVariable>mList;
    public ListAdapter(Context context,List<DataVariable>mList){
        this.mList=mList;
        this.context=context;

    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(context, R.layout.hair_item,null);
        ImageView image=(ImageView)v.findViewById(R.id.imv_item);
        TextView textView=(TextView)v.findViewById(R.id.tv_item);

       image.setImageResource(R.drawable.shape);
        textView.setText(mList.get(i).getTitle());



        return v;
    }


}
