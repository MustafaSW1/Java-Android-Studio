package com.example.roomwordsample;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>>mWordsAll; // wort live data initialisieren
    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mWordsAll = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<Word>>getAllWords(){
        return mWordsAll;
    }

    //wort in dem data base eingeben
    void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(()->{
           mWordDao.insert(word);
        });
    }

    // wort löschen
    void deleteOne(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.deleteOne(word);
        });
    }

    //um ein wort aktualisieren
    void updateWord(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.updateWord(word);
        });
    }
}
