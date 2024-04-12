package com.mustafa.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/*

Das Beispiel ist für eine RatingBar, damit man etwas Bestimmtes bewerten kann
 */
public class MainActivity extends AppCompatActivity {

    Button buttonshow;
    TextView textViewResult;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI elemente mit id verknüpfen
       textViewResult = findViewById(R.id.mytextview);
       ratingBar = findViewById(R.id.ratingBar);
       buttonshow = findViewById(R.id.buttonshow);


        // bewertungsprozess
       buttonshow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // die bewertung muss String sein
               String ratting = ratingBar.getRating()+"";
               textViewResult.setText(ratting);

               //die bewertung in Toast Nachricht anzeigen
               Toast.makeText(getApplicationContext(),
                       "your result "+ratting,Toast.LENGTH_LONG).show();
           }
       });
    }
}