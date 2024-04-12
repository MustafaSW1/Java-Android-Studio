package com.mustafa.listview_adapter;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    GridView gridView;
    int r;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);
        ArrayList<String> names = new ArrayList<>();
        names.add("aaaaaa");
        names.add("bbbbbbb");
        names.add("ccccccc");
        names.add("ddddddd");
        names.add("eeeeeee");
        names.add("aaaaaa");
        names.add("bbbbbbb");
        names.add("ccccccc");
        names.add("ddddddd");
        names.add("eeeeeee");
        names.add("aaaaaa");
        names.add("bbbbbbb");
        names.add("ccccccc");
        names.add("ddddddd");
        names.add("eeeeeee");




        MyAdapter myAdapter = new MyAdapter(this,names);

        gridView.setAdapter(myAdapter);

    }
}


