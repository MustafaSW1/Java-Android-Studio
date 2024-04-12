package com.mustafa.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/*

Dies ist ein einfaches Beispiel für einen internen Speicher,
sodass Sie die Daten im internen Speicher speichern und wieder abrufen können

 */
public class MainActivity extends AppCompatActivity {

    Button btn_save,btn_restore;
    EditText et_userName ,et_eMail ,et_birthDate;
    TextView infoViewer;
    public static final String FILE_NAME = "users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Schaltflächen mit id verknüpfen
        btn_save = findViewById(R.id.btn_save);
        btn_restore = findViewById(R.id.btn_restore);

        // Texteingabe Bereich mit der ID Verknüpfen
        et_userName = findViewById(R.id.edit_text_username);
        et_eMail = findViewById(R.id.edit_text_email);
        et_birthDate = findViewById(R.id.edit_text_birthdate);

        // Textanzeiger mit der ID Verknüpfen
        infoViewer = findViewById(R.id.info_viewer);


        // speichern-Schaltfläche
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String variablen für EditText definieren
                String username = et_userName.getText().toString();
                String email = et_eMail.getText().toString();
                String birthdate = et_birthDate.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput("users",MODE_PRIVATE); //Datei öffnen

                    // in die Datei schreiben
                    PrintWriter pw = new PrintWriter(fos);
                    pw.println(username+"\n "+email+"\n "+birthdate);

                    pw.close(); //schließen
                    fos.close(); //schießen
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Nachdem Sie auf die Schaltfläche „Speichern“ geklickt haben,
                // sollte der gesamte Bearbeitungstext leer sein
                et_userName.setText("");
                et_eMail.setText("");
                et_birthDate.setText("");

            }
        });


        // wiederherstellen-Schaltfläche
        btn_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    // Die gespeicherte daten wiederherstellen
                    FileInputStream fis = openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);

                    String allText = "\n"; // \n = neue Zeile
                    String temp;
                    while ((temp=br.readLine())!= null){
                         allText += temp+"\n";
                    }
                    br.close();
                    isr.close();
                    fis.close();
                    Toast.makeText(MainActivity.this, allText, Toast.LENGTH_SHORT).show();
                    infoViewer.setText(allText);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}