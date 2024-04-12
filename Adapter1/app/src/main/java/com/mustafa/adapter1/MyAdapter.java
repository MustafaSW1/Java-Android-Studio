package com.mustafa.adapter1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{

    Context c;
    ArrayList<String> data;

    public MyAdapter(Context c,ArrayList<String> data){
        this.c = c;
        this.data = data;
    }

    public void AddItem(String item){
        data.add(item);
    }

    public void SetItem(int pos,String item){
        data.set(pos , item);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null){
            v = LayoutInflater.from(c).inflate(android.R.layout.simple_list_item_1,null,false);
            TextView tv = v.findViewById(android.R.id.text1);
            String mustafa = data.get(position);
            tv.setText(mustafa);
        }

        return v;
    }
}
