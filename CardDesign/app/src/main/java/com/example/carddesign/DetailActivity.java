package com.example.carddesign;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);



        String mTitle = sportsTitle.getText().toString();
        int mImage = sportsImage.getImageAlpha();

        // get the info from  Intent extra.
        Intent intent = getIntent();
        mTitle = intent.getStringExtra("title");
        mImage = intent.getIntExtra("image_resource",0);


        sportsTitle.setText(mTitle);
        sportsImage.setImageResource(mImage);


    }
}