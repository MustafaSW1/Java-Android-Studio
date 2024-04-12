package com.mustafa.action;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;

/*

Speichern von Nummer mit persönlichen Informationen

 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(Intent.ACTION_INSERT,
                ContactsContract.Contacts.CONTENT_URI);
        //Intent intent = new Intent(Intent.ACTION_INSERT);
        //intent.setData(ContactsContract.Contacts.CONTENT_URI);

        //werte eingeben
        intent.putExtra("finishActivitySavedCompleted",true);
        intent.putExtra(ContactsContract.Intents.Insert.NAME,"mustafa Devaloper");
        intent.putExtra(ContactsContract.Intents.Insert.PHONE,"1644614646464+4");
        intent.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,
                ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL,"mustafa.gjhguguzfuzfzt@gmail.com");
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL_ISPRIMARY,"mustafa.sjkbghjfdgh@gmail.com");

        
        startActivity(intent); // durchführen
        

    }

}