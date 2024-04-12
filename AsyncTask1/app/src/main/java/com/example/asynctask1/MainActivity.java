package com.example.asynctask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


/*
dieser Code führt ein ProgressBar in hintergrund durch und zeigt die Aktualisierung
von ProgressBar in TextView bis 100% an
 */
public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_download);
        textView = findViewById(R.id.textview);  // Anzeigen von Prozent (%)
        progressBar = findViewById(R.id.progressBar); // Anzeigen von progressBar

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask task = new MyTask();
                task.execute(); // Durchführen von task
            }
        });

    }

    // Task-Klasse

    class MyTask extends AsyncTask<String ,Integer ,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }


        // Aktualisieren von ProgressBar bis 100
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.incrementProgressBy(values[0]);
            textView.setText(progressBar.getProgress() + " / " + 100);
        }


       // Nach der durchführung :: verstecken von text und ProgressBar
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            textView.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
        }


        // Aufgeben im hintergrund durchführen
        @Override
        protected Void doInBackground(String... strings) {

            // jede sekunde +10% in ProgressBar
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(10);
            }
            return null;
        }
    }
}


/*
int z = sum(10);

    public int sum(int... x ){
        int res = 0;
        for (int i = 0; i < x.length; i++) {
            res += x[i];
        }
        return res;
        }
 */