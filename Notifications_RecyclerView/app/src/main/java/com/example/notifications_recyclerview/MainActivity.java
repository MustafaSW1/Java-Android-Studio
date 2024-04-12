package com.example.notifications_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.example.notifications_recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

/*

das ist ein Beispiel für recyclerview mit notification mit möglichkeit auf dem element
im recyclerview zuklicken danach bekommt man eine benachrichtigung.

 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<User> users = new ArrayList<>(); // Nutzer ArrayList
        // daten die nutzer eingeben
        users.add(new User(R.drawable.ic_user1,"mustafa ","mustafa.sw2000@gmail.com",6800));
        users.add(new User(R.drawable.ic_user2,"ibraheem ","ibra@gmail.com",5300));


        // initialisieren von Adapter
        UsersAdapter adapter = new UsersAdapter(users, new UsersAdapter.OnUserClickListener() {
            @Override
            public void onUserclicklistener(User user) {
                showNotification(user);
            }
        });

        binding.mainRv.setAdapter(adapter);
        binding.mainRv.setLayoutManager(new LinearLayoutManager(this));
        binding.mainRv.setHasFixedSize(true);
    }


    // initialisieren von benachrichtigung
    public void showNotification(User user){
        String channelID = "BE1";
        Intent intent = new Intent(getBaseContext(),MainActivity.class);


        PendingIntent pi = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channelID);
        builder.setSmallIcon(user.getImage())
                .setContent(getCustomDesign(user))
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setContentIntent(pi);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel(channelID,user.getName(),NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);

        manager.notify(1,builder.build());
    }

    private RemoteViews getCustomDesign(User user){

        RemoteViews rv = new RemoteViews(getApplicationContext().getPackageName(),R.layout.custom_user_item);
        rv.setTextViewText(R.id.user_tv_email,user.getEmail());
        rv.setTextViewText(R.id.user_tv_name,user.getName());
        rv.setTextViewText(R.id.user_tv_salary,user.getSalary()+" $");
        rv.setImageViewResource(R.id.user_iv,user.getImage());

        return rv;
    }
}