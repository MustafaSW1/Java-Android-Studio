package com.mustafa.sharedprfrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*

das ist ein beispiel für SharedPreferences damit man wort speichern kann.

folgene schritte um die app zu nutzen:

1 - führen Sie der Code durch
2 - geben sie ein wort oder text im EditText ein
3 - klicken Sie auf save
4 - zerstören Sie die app
5 - Öffnen Sie die App erneut, da Sie das Wort finden, das Sie zuvor geschrieben haben

 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button save;
    private static final String MYKEY = "Select";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI elemente mit id verknüpfen
        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.editTextTextPersonName);
        save = findViewById(R.id.button);

        // speichern-Schaltfläche
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialisieren von sharedPreferences
                sharedPreferences = getSharedPreferences(MYKEY,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("msg", editText.getText().toString()); // key ist (msg) wird unten benutzt
                editor.commit();
            }
        });
        SharedPreferences preferences = getSharedPreferences(MYKEY,0);

      if (preferences.contains("msg")){ // (key :: msg )wenn sharedPreferences enthält msg folgende zeilen werden durchgeführt
          String mymsg = preferences.getString("msg","not found"); // der gespeicherte text oder wort
          textView.setText(mymsg); // in dem textview hingefügt
      }


    }
}