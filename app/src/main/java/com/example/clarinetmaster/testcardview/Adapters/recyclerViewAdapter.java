package com.example.clarinetmaster.testcardview.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clarinetmaster.testcardview.Model.Card;
import com.example.clarinetmaster.testcardview.R;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.GenericHolder> {

    private Context context;
    private ArrayList<Card> cards;

    public recyclerViewAdapter(Context context, ArrayList<Card> cards) {
        this.context = context;
        this.cards = cards;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 + 1;
    }

    @Override
    public GenericHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        ViewHolder holder = new ViewHolder(v, cards);
        return holder;
    }

    @Override
    public void onBindViewHolder(GenericHolder holder, int position) {
        holder.setViewData(cards.get(position).getName(), cards.get(position).getImage(), cards.get(position).getScore());
        holder.cardView.setCardBackgroundColor(getColorByScore(position));
    }

    public int getColorByScore(int position){
        if(cards.get(position).getScore() < 30) return Color.RED;
        else if(cards.get(position).getScore() < 50) return Color.YELLOW;
        else return Color.GREEN;
    }

    @Override
    public int getItemCount() {
        return cards.size(); // Recycler view ends at return value
    }

    public abstract static class GenericHolder extends RecyclerView.ViewHolder{

        public CardView cardView = (CardView) itemView.findViewById(R.id.cv);;

        public GenericHolder(View itemView){
            super(itemView);
        }

        abstract public void setViewData(String name, int imageId, int score);

    }

    public static class ViewHolder extends GenericHolder /*implements View.OnClickListener*/{
        private final TextView nameTextView;
        private final ImageView imageView;
        private final TextView scoreView;
        private final ArrayList<Card> cards;

        public ViewHolder(final View itemView, ArrayList<Card> cards){
            super(itemView);
            this.cards = cards;
            nameTextView = (TextView) itemView.findViewById(R.id.person_name);
            imageView = (ImageView) itemView.findViewById(R.id.person_photo);
            scoreView = (TextView) itemView.findViewById(R.id.person_score);
            //imageView.setOnClickListener(this);
        }
/*
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(v.getId() == R.id.person_photo){
                Log.i("selection", cardposition]);
            }
        }
        */

        @Override
        public void setViewData(String name, int imageId, int score) {
            nameTextView.setText(name);
            imageView.setImageResource(imageId);
            scoreView.setText(Integer.toString(score));
        }

    }

}
