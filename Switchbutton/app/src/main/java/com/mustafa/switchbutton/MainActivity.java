package com.mustafa.switchbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/*

das ist ein sehr einfaches Beispiel für switch button.
status der switch wird in dem textview angezeigt.

 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.mytextview);
        aSwitch = findViewById(R.id.switch1);


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){ // status ON
                    textView.setVisibility(View.VISIBLE); // Sichtbar
                    textView.setText("ON");

                }else { // status OFF
                    textView.setVisibility(View.VISIBLE); // Sichtbar
                    textView.setText("OFF");
                }
            }
        });

    }
}