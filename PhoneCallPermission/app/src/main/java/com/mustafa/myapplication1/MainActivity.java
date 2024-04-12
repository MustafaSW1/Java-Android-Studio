package com.mustafa.myapplication1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*

das ein Beispiel für Anruferlaubnis mit möglichkeit eine nummer einzugebgen
und sie anrufen.

 */

public class MainActivity extends AppCompatActivity {

Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Frage nach Anruferlaubnis wenn Android-SDK 23 oder höher
        if (Build.VERSION.SDK_INT >= 23 ){
            if (checkPermission()){
                Toast.makeText(getApplicationContext(),"permission granted",Toast.LENGTH_LONG).show();
            }else {
                requestPermission();
            }
        }

    }

    // 1 bit boolean methode (true oder false) um das Anruferlaubnis überprüfen
    public boolean checkPermission(){

        int callPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE);
        return callPermissionResult == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission(){

        ActivityCompat.requestPermissions(
                MainActivity.this,new String[]{
                        Manifest.permission.CALL_PHONE},1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 1:
                button = findViewById(R.id.call);
                if (grantResults.length>0){
                   boolean  callPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                   if (callPermission){
                       Toast.makeText(MainActivity.this,"accepted it",Toast.LENGTH_LONG).show();
                   }else {
                       Toast.makeText(MainActivity.this,"you didn't accepted it",Toast.LENGTH_LONG).show();
                       button.setEnabled(false);
                   }
                   break;

                }
        }
    }

    // initialisieren von Anrufprozes
    public void call(View view){
        final EditText phoneNumber = findViewById(R.id.phone);
        String phoneNum = phoneNumber.getText().toString();
        if (!TextUtils.isEmpty(phoneNum)){
            String dail = "tel: "+phoneNum;
            if (checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dail)));
        }else {
            Toast.makeText(MainActivity.this,"please put number",Toast.LENGTH_LONG).show();
        }

    }

}