package com.mustafa.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/*

Dies ist ein einfaches Beispiel für ein Kontrollkästchen. Aktivieren Sie eines oder mehrere der Kontrollkästchen
und klicken Sie dannKlicken Sie auf die Schaltfläche „show“, um das ausgewählte Kontrollkästchen in der Textview anzuzeigen
 */

public class MainActivity extends AppCompatActivity {

    //Initialisieren von elemente der benutzeroberfläche
    private TextView results;
    private CheckBox checkJava ,checkPython ,checkRuby ,checkPHP;
    private Button buttonShow;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //die variablen mit id verknüpfen

        results = findViewById(R.id.mytextview);

        checkJava = findViewById(R.id.java);
        checkPython = findViewById(R.id.python);
        checkRuby = findViewById(R.id.ruby);
        checkPHP = findViewById(R.id.php);

        buttonShow = findViewById(R.id.buttonShow);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder(); //stringbuilder wird die werte enthalten
                if (checkJava.isChecked()){
                    stringBuilder.append(checkJava.getText().toString()+" \n"); // \n = neue Zeile
                }

                if (checkPython.isChecked()){
                    stringBuilder.append(checkPython.getText().toString()+" \n");
                }

                if (checkRuby.isChecked()){
                    stringBuilder.append(checkRuby.getText().toString()+" \n");
                }

                if (checkPHP.isChecked()){
                    stringBuilder.append(checkPHP.getText().toString()+" \n");
                }

                results.setText(stringBuilder); // die werte in textview anzeigen
            }
        });


    }
}