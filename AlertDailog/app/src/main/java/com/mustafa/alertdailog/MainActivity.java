package com.mustafa.alertdailog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Dieser Code zeigt einen Dialog ,wenn Sie die App verlassen möchten
 */
public class MainActivity extends AppCompatActivity {

    Button button;
    AlertDialog.Builder alertDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               alertDailog = new AlertDialog.Builder(MainActivity.this);
               alertDailog.setTitle(getResources().getString(R.string.hello));
               alertDailog.setMessage(getResources().getString(R.string.attention));
               alertDailog.setCancelable(false);

               //Positiver Knopf
               alertDailog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       MainActivity.this.finish();
                   }
               });

               //Negativer Knopf
               alertDailog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });

               // Anzeigen von Alert Dialog
               AlertDialog dialog = alertDailog.show();
           }
       });
    }
}