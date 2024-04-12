package com.mustafa.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/*

das ist ein beispiel für SeekBar und prozent der SeekBar wird in einem text angezeigt

in dem text wird auch status der SeekBar angezeigt ob er  onProgressChanged oder onStartTrackingTouch
oder onStopTrackingTouch ist.

 */
public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar2); //seekBar mit id verknüpfen
        textView = findViewById(R.id.textView5); // textview mit id verknüpfen


        // die durchführung von SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //auf Fortschrittsänderung
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(" ");
                textView.setText(progress+" onProgressChanged"); // Fortschritt und status werden in dem textview angezeigt

            }


            // Wenn die Verfolgung aktiviert ist
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText(" ");
                textView.append("onStartTrackingTouch"); // status wird angezeigt

            }


            // Wenn die Verfolgung deaktiviert ist
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText(" ");
                textView.append("onStopTrackingTouch"); // status wird angezeigt

            }
        });

    }
}