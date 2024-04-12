package com.mustafa.mynewclculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Das ist ein Rechner damit man addieren und multiplizieren
*/

public class MainActivity extends AppCompatActivity {

    private Button buttonSum , buttonMulit;
    private TextView textViewresult; //Ergebnis
    private EditText number1 ,number2; // (+ und *)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI elemente mit id verknüpfen
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        buttonSum = findViewById(R.id.buttonSum);
        buttonMulit = findViewById(R.id.buttonMulti);
        textViewresult = findViewById(R.id.result);

        //addieren
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // die int nummer muss ein String werden
                String mynumber1 = number1.getText().toString();
                String mynumber2 = number2.getText().toString();

                // wenn EditText leer ist einen text wird angezeigt
                if (mynumber1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_LONG).show();

                    // wenn EditText leer ist einen text wird angezeigt
                }else if (mynumber2.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_LONG).show();
                }
                else {
                    //String nummer muss double werden
                    Double input1 = Double.parseDouble(mynumber1);
                    Double input2 = Double.parseDouble(mynumber2);
                    sumvalues(input1,input2).toString();

                    //das Ergebnis muss als String angezeigt werden
                    String finalvalue = String.valueOf(sumvalues(input1,input2));
                    textViewresult.setText("Result :  "+finalvalue);
                }
            }
        });

        // multiplizieren
        buttonMulit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // die nummer muss ein String werden
                String mynumber1 = number1.getText().toString();
                String mynumber2 = number2.getText().toString();

                // wenn EditText leer ist einen text wird angezeigt
                if (mynumber1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_SHORT).show();

                    // wenn EditText leer ist einen text wird angezeigt
                }else if (mynumber2.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_SHORT).show();
                }
                else {
                    //String nummer muss double werden
                    Double input1 = Double.parseDouble(mynumber1);
                    Double input2 = Double.parseDouble(mynumber2);
                    multivalues(input1,input2);

                    //das Ergebnis muss als String angezeigt werden
                    String finalvalue = String.valueOf(multivalues(input1,input2));
                    textViewresult.setText("Result :"+finalvalue);
                }
            }
        });

    }

    public Double sumvalues(Double number1, Double number2){

        Double result = number1 + number2;
        return result;
    }

    public Double multivalues(Double number1, Double number2){
        Double result = number1 * number2;
        return  result;
    }
}