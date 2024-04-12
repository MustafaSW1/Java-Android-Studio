package com.example.roomwordsample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


public class WordViewHolder extends RecyclerView.ViewHolder {

    final TextView wordItemView;
    ImageButton imageButton;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textView);
        imageButton = itemView.findViewById(R.id.imageButton);

    }


    public void bind(String text) {
        wordItemView.setText(text);
        WordViewModel mWordViewModel = new WordViewModel(null);

        // wort löschen
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder;

                builder = new AlertDialog.Builder(wordItemView.getContext());

                builder.setMessage("this Element will be deleted");
                builder.setCancelable(false);

                // bestätigung der löschung entscheidung
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Word word = new Word(text);
                        mWordViewModel.deleteOne(word);
                    }
                });

                // stornieren der löschung entscheidung
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel(); // dialogInterface verstäcken
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }




    static WordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }


    static class WordDiff extends DiffUtil.ItemCallback<Word> {

        
        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.getWord().equals(newItem.getWord());
            
        }
    }
}
