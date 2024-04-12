package com.example.level_list_drawal;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/*
Das ist ein Beispiel für Level list drawable mit plus und minus Schaltflächen
und Batarie bild .

Wenn man auf Plus oder Minus tippt, ändert sich der Batterieprozentsatz.
 */
public class MainActivity extends AppCompatActivity {

    ImageButton plus;
    ImageButton minus;
    ImageView imageView;
    private LevelListDrawable levelListDrawable;
    private int x = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus = findViewById(R.id.imageButton1);
        minus = findViewById(R.id.imageButton2);
        imageView = findViewById(R.id.imageView);

        //plus Schaltfläche
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //6 Batterie Ebenen
                // x = Ebenen
                if (x<6)
            x++;
            imageView.setImageLevel(x);

            }
        });


        ////mimus Schaltfläche
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(x>0)
                x--;
                imageView.setImageLevel(x);
            }
        });


    }
}