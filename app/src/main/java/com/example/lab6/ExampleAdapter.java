package com.example.lab6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private onBtnClick onbc;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView description;
        public TextView status;
        public TextView category;
        public TextView duration;

        public onBtnClick onbc;
        public ExampleViewHolder(View itemView, onBtnClick onbc) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            status = itemView.findViewById(R.id.status);
            category = itemView.findViewById(R.id.category);
            duration = itemView.findViewById(R.id.duration);
            this.onbc = onbc;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onbc.onClick(getAdapterPosition());
        }
    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList, onBtnClick onbc) {
        mExampleList = exampleList;
        this.onbc = onbc;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, onbc);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
        holder.status.setText(currentItem.getStatus());
        holder.category.setText(currentItem.getCategory());
        holder.duration.setText(currentItem.getDuration());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    interface onBtnClick{
        void onClick(int position);
    }
}