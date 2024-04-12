package com.mustafa.adapter1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.StorageStatsManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/*
Mit diesem Code Sie können namen ein geben und in der liste anzeigen
 */
public class MainActivity extends AppCompatActivity {

    ListView lv; // ListView zur Anzeige der Elemente
    EditText et_name; // EditText für die Eingabe von Namen
    Button btn_add; // Button zum Hinzufügen Elementen
    MyAdapter myAdapter; // Adapter für die ListView zur Anzeige der Elemente
    int currentposition = -1; // Speichert die Position des aktuell ausgewählten Elements, standardmäßig auf -1 gesetzt

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Setzt das Layout für die Aktivität

        // Initialisierung der Views
        lv = findViewById(R.id.test_list); // ListView initialisieren
        et_name = findViewById(R.id.list_edittext); // EditText für die Eingabe von Namen initialisieren
        btn_add = findViewById(R.id.btn_list); // Button zum Hinzufügen/ Bearbeiten initialisieren

        ArrayList<String> names = new ArrayList<>(); // Liste für die Namen initialisieren

        // ArrayAdapter für die ListView initialisieren und mit der Liste der Namen verknüpfen
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        // myAdapter für die ListView initialisieren und mit der Liste der Namen verknüpfen
        myAdapter = new MyAdapter(this, names);
        lv.setAdapter(myAdapter); // Setzt den Adapter für die ListView

        // OnClickListener für die ListView-Einträge, um den ausgewählten Namen im EditText anzuzeigen
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et_name.setText(names.get(position)); // Setzt den ausgewählten Namen im EditText
                currentposition = position; // Aktuelle Position aktualisieren
                btn_add.setText("Edit"); // Ändert den Text des Buttons auf "Edit"
            }
        });

        // OnClickListener für den Hinzufügen/Bearbeiten-Button
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Überprüft, ob ein Element bearbeitet werden soll oder ein neues hinzugefügt werden soll
                if (currentposition >= 0) {
                    // Wenn ein Element bearbeitet wird, aktualisiert der Adapter das Element an der aktuellen Position
                    myAdapter.SetItem(currentposition, et_name.getText().toString());
                    btn_add.setText("Add"); // Ändert den Text des Buttons auf "Add"
                    currentposition = -1; // Setzt die aktuelle Position zurück
                } else {
                    // Wenn ein neues Element hinzugefügt wird, fügt der Adapter den Namen hinzu
                    myAdapter.AddItem(et_name.getText().toString());
                    et_name.setText(" "); // Leert den EditText
                }
                myAdapter.notifyDataSetChanged(); // Benachrichtigt den Adapter über Datenänderungen
            }
        });

    }
}