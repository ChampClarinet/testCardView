package com.example.clarinetmaster.testcardview.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clarinetmaster.testcardview.R;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.GenericHolder> {

    private Context context;
    private String[] dataSet;

    public recyclerViewAdapter(Context context, String[] dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 + 1;
    }

    @Override
    public GenericHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(GenericHolder holder, int position) {
        holder.setViewData(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length; // Recycler view ends at return value
    }

    public abstract static class GenericHolder extends RecyclerView.ViewHolder{

        public GenericHolder(View itemView){
            super(itemView);
        }

        abstract public void setViewData(String data);

    }

    public static class ViewHolder extends GenericHolder{
        private final TextView nameTextView;
        private final ImageView imageView;

        public ViewHolder(final View itemView){
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.person_name);
            imageView = (ImageView) itemView.findViewById(R.id.person_photo);
        }

        @Override
        public void setViewData(String data) {
            nameTextView.setText(data);
        }
    }

}
