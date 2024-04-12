package com.mustafa.bluetooth_project;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



/*
der Code ist um Bluetooth ein und aus geschaltet
 */
public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button on ,off;
    ImageView imageView;

    BluetoothAdapter bluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.text_view1);
        on = findViewById(R.id.buttonOn);
        off = findViewById(R.id.buttonOFF);
        imageView = findViewById(R.id.imageView1);

        //bluetooth Adapter initialisieren
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // bluethooth einschalten
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Default einstellungen Wenn bluetooth ist nicht eingeschaltet
                if (!on.isPressed()){
                    textView.setTextColor(Color.RED); // rote farbe
                   textView.setText("Bluetooth is OFF");
                    Toast.makeText(MainActivity.this,"Turned OFF",
                                Toast.LENGTH_LONG).show();
                    bluetoothAdapter.disable(); //Bluetooth deaktivieren

                    //bluetooth einschalten
                }else {
                    textView.setTextColor(Color.GREEN); //grüne farbe
                    textView.setText("Bluetooth is ON");
                    Toast.makeText(MainActivity.this,"Turned ON",
                            Toast.LENGTH_LONG).show();
                    bluetoothAdapter.enable();  // Bluetooth aktivieren
                    imageView.setColorFilter(Color.GREEN); //grüne farbe
                    Intent intenton = new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intenton,0);

                }
            }
        });
        //bluethooth ausschalten
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (off.isPressed()){
                    textView.setText("Bluetooth is OFF");
                    textView.setTextColor(Color.RED); // rote farbe
                    imageView.setColorFilter(Color.RED); // rote farbe
                    Toast.makeText(MainActivity.this,"Turned OFF",
                            Toast.LENGTH_LONG).show();
                    bluetoothAdapter.disable(); // Bluetooth deaktivieren

                }
            }
        });
    }
}