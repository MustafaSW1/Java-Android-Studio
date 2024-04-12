package com.example.ui_testing;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/*

das ist ein Beispiel für UI testing damit die app automatisch funktioniert.

Es gibt zwei Edittext, eines für den Benutzernamen und eines für das Passwort,
und während des UI-Tests werden die Werte automatisch mehrmals ohne menschliches Eingreifen eingegeben

Achtung : der nutzer muss keine text in edittext eingeben.

zum starten

 1 - MainActivity starten
 2 - Android -> com.example.ui_testing -> MainActivityTest rechte maus and starten dann ui test wird aktiviert
 */

public class MainActivity extends AppCompatActivity {



    EditText userName,password;
    Button start;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // edittext mit ui verknüpfen
        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.pass_word);
        //Schaltfläche mit ui verknüpfen
        start = findViewById(R.id.btn_send);

        String user = userName.getText().toString();
        String pass = password.getText().toString();





        start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        count++; //Zähler
                        userName.setText(user); // um das wert einzugeben
                        password.setText(pass); // um das wert einzugeben

                        if (count >= 5) // von 0 bis 5
                            Toast.makeText(getBaseContext(), "to many tries", Toast.LENGTH_SHORT).show();
                }
            });

    }
}