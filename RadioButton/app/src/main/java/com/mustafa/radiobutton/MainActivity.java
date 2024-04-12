package com.mustafa.radiobutton;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/*

das ist einfaches Beispiel für RadioButton in einem RadioGroup

 */
public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.RadioGrupeid); // RadioButton mit id verknüpfen
        textView = findViewById(R.id.textView); // textView mit id verknüpfen

        // initialisieren von radioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,@IdRes int checkedId) {

                radioButton = findViewById(checkedId);
                switch (radioButton.getId()) {
                    case R.id.pizzaid: {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("Pizza");
                    }
                    break;
                    case R.id.hambergerid: {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("hamburger");
                    }
                    break;
                    case R.id.steak: {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("Steak");
                    }
                }
            }
        });
        }
        }
