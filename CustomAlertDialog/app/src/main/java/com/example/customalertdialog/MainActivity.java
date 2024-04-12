package com.example.customalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*

Dies ist ein einfaches Beispiel für die Erstellung eines benutzerdefinierten AlertDialogs,
wenn Sie Ihren eigenen Dialog entwerfen möchten.

Mit Diesem Beispiel es ist möglich einen text in dem  Dialog einzugeben und beim Ok klicken den text
wird in Toast Nachricht angezeigt.
 */

public class MainActivity extends AppCompatActivity implements
        DalogFragment.OnPositiveClickListener, //Positive Schaltfläche
        DalogFragment.OnNegativeClickListener, // Negative Schaltfläche
        DalogFragment.OnNeutralClickListener { //Neutrale Schaltfläche

    Button showAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAlert = findViewById(R.id.show_alert); // showAlert schaltfläche mit id verknüpfen

        // Anzeigen von AlertDialog
        showAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DalogFragment fragment = DalogFragment.newInstance
                        ("Description","i need configuration",R.drawable.ic_launcher_background);
                fragment.show(getSupportFragmentManager(),null);
            }
        });
    }

    // Positive Schaltfläche (Yes oder OK) in dem AlertDialog
    //"Clicked on YES" wird anezeigt
    @Override
    public void onPositiveClickListener(String text) {
        Toast.makeText(getBaseContext(), "Clicked on YES "+text, Toast.LENGTH_SHORT).show();
    }


    // Negative Schaltfläche (No) in dem AlertDialog
    //"Clicked on NO" wird anezeigt
    @Override
    public void onNegativeClickListener() {
        Toast.makeText(getBaseContext(), "Clicked on NO ", Toast.LENGTH_SHORT).show();
    }

    //Neutrale Schaltfläche in dem AlertDialog
    //"Clicked on Neutral" wird anezeigt
    @Override
    public void onNeutralClickListener() {
        Toast.makeText(getBaseContext(), "Clicked on Neutral ", Toast.LENGTH_SHORT).show();
    }

}