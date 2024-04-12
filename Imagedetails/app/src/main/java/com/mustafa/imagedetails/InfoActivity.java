package com.mustafa.imagedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView name , info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageView);
        name = findViewById(R.id.textViewName);
        info = findViewById(R.id.textViewInfo);

        // empfangen Daten
        Bundle extras = getIntent().getExtras();
        if (extras!= null){
            String name = extras.getString("Name");
            String details = extras.getString("details");
            String infoKey = extras.getString("myKey");
            showInfo(name,details,infoKey);
        }
    }

    public void showInfo(String name1 , String details1,String infoKey1){
        //Android-Anzeigezustand
        if (infoKey1.equals("Android")){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.android));
            name.setText(name1);
            info.setText(details1);

         //Java-Anzeigezustand
        }else if (infoKey1.equals("java")){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon));
            name.setText(name1);
            info.setText(details1);
        }
    }
}