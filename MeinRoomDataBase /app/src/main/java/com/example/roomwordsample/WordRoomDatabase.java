package com.example.roomwordsample;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static volatile WordRoomDatabase INSTACE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static final RoomDatabase.Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                WordDao dao = INSTACE.wordDao();

                Word word = new Word("hallo");
                dao.insert(word);

                word = new Word("world");
                dao.insert(word);


            });
        }
    };

    // herstellen von RoomDataBase

    static WordRoomDatabase getDatabase(final Context context){
        if (INSTACE == null){
            synchronized (WordRoomDatabase.class){
                if (INSTACE == null){
                    INSTACE = Room.databaseBuilder(context.getApplicationContext()
                            ,WordRoomDatabase.class,"word_datebase")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTACE;
    }
}
