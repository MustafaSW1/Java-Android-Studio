package com.mustafa.coordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


/*

Das ist einfacher Beispiel für mit FloatingActionButton Rückgängig-Option.
FloatingActionButton ist eine Taste.

ACHTUNG : bei nutzung von FloatingActionButton man bevorzugt coordinatorlayout zu benutzen

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton btn; // Taste
        btn = findViewById(R.id.btn_snack); // Taste mit id verknüpfen

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //beim klicken "click to button" wird angezeigt
                Snackbar s = Snackbar.make(btn,"click to button", Snackbar.LENGTH_SHORT);

                //beim undo klicken "you clicked Undo" wird angezeigt
                s.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "you clicked Undo", Toast.LENGTH_SHORT).show();
                    }
                });
                s.show();
            }
        });
    }
}