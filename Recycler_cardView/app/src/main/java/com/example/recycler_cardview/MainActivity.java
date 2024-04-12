package com.example.recycler_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import P_Adapter.MyAdapter;
import P_Model.Listitem;

/*

das ist ein beispiel für recyclerview mit möglichkeit auf einem elemenet zuklicken.
beim klicken von recyclerview element ,die geklickte element wird in einem anderen activity angezeigt.

in dem recyclerview card sind paar virtuelle Daten eingegeben sowie name ,alt und beschreibung
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Listitem> listitems;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialisieren von recyclerView
        recyclerView = findViewById(R.id.recyclerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         listitems = new ArrayList<Listitem>();

         // werte in der ArrayList eingeben
        Listitem item1 = new Listitem("Mustafa","Softwareentwickler","21");
        Listitem item2 = new Listitem("ahmed","lehrer","25");
        Listitem item3 = new Listitem("ibraheem","Minester","41");
        Listitem item4 = new Listitem("jawhar","Fahrer","27");
        Listitem item5 = new Listitem("Mecheal","Fahrlehrer","51");
        Listitem item6 = new Listitem("jbar","Bauengenuerin","21");
        Listitem item7 = new Listitem("ali","Rechtsanwalt","21");
        Listitem item8 = new Listitem("murad","Entwickler","24");
        Listitem item9 = new Listitem("mahir","Bauarbeiter","21");
        Listitem item10 = new Listitem("yasmin","Informatikerin","21");


        // werte in die liste hinfügen
        listitems.add(item1);
        listitems.add(item2);
        listitems.add(item3);
        listitems.add(item4);
        listitems.add(item5);
        listitems.add(item6);
        listitems.add(item7);
        listitems.add(item8);
        listitems.add(item9);
        listitems.add(item10);


        // die liste in dem adapter eingeben
        adapter = new MyAdapter(this,listitems);

        // recyclerView enthält den Adapter
        recyclerView.setAdapter(adapter);
    }
}


