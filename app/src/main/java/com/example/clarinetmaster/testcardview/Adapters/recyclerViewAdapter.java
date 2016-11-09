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
        ViewHolder holder = new ViewHolder(v, dataSet);
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

    public static class ViewHolder extends GenericHolder implements View.OnClickListener{
        private final TextView nameTextView;
        private final ImageView imageView;
        private final String[] dataSet;

        public ViewHolder(final View itemView, String[] dataSet){
            super(itemView);
            this.dataSet = dataSet;
            nameTextView = (TextView) itemView.findViewById(R.id.person_name);
            imageView = (ImageView) itemView.findViewById(R.id.person_photo);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(v.getId() == R.id.person_photo){
                Log.i("selection", dataSet[position]);
            }
        }

        @Override
        public void setViewData(String data) {
            nameTextView.setText(data);
        }
    }

}
