package com.example.carddesign;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

/*

in dieser klasse recyclerview und viewholder werden initialisiert

 */

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {


    private ArrayList<Sport> mSportsData;
    private Context mContext;

    //constructor
    SportsAdapter(Context mContext, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = mContext;

    }


    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }


    @Override
    public void onBindViewHolder(SportsAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Sport currentSport = mSportsData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentSport);
    }


    @Override
    public int getItemCount() {
        return mSportsData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // Member Variables for the TextViews
        //Card elemente definieren
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;


        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Sport currentSport){
            // Populate the textviews with data.
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            mSportsImage.setImageResource(currentSport.getImageResource());

        }


        // Wenn Sie auf ein Card klicken, werden Titel und Bild in eine andere Aktivität verschoben
        // und werden in der andere Aktivität angezeigt
        @Override
        public void onClick(View view) {
            Sport currentSport = mSportsData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentSport.getTitle());
            detailIntent.putExtra("image_resource", currentSport.getImageResource());
            mContext.startActivity(detailIntent);// Titel und Bild werden in DetailActivity verschoben
        }
    }
}
