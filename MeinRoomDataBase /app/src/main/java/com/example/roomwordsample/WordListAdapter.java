package com.example.roomwordsample;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class WordListAdapter extends ListAdapter<Word, WordViewHolder> {


    public WordListAdapter(@NonNull DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {

        //position bekommen um ein bestimmtes wort zulöschen
        Word current = getItem(position);
        holder.bind(current.getWord());
        Word wordDelete = getItem(position);
        holder.bind(wordDelete.deleteword());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent intent = new Intent(view.getContext(),NewWordActivity.class);
                intent.putExtra("MyKey",current.getWord());
                view.getContext().startActivity(intent);
                return true;

            }

        });



    }

}
