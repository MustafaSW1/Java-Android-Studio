package com.mustafa.mycalendar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/*

Dieser Code zeigt auch den Tag des Jahres und die Uhrzeit an

*/
public class MainActivity extends AppCompatActivity {

    TextView textView;
    Calendar calendar;
    Button btn;
    SimpleDateFormat simpleDateFormat;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance(); //calendar initialisieren
                textView.append("the day is "+calendar.get(Calendar.DAY_OF_YEAR)+" from year "+
                        calendar.get(Calendar.YEAR)); // Calender(tag und jahr) in textview hinfügen

                try {
                    Thread.sleep(1000);
                    simpleDateFormat = new SimpleDateFormat("HH:mm:ss"); // HH = stunden, mm = minuten  ,ss = sekunden
                    date = simpleDateFormat.format(calendar.getTime()); //string date wird die Uhrzeit enthalten
                    textView.append("\n\n"+"the Time is "+date); // die Uhrzeit in n textview hinfügen . \n = Neue Zeile
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}