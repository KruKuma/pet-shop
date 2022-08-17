package com.example.petshopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cardViewRecyclerViewAdapter extends RecyclerView.Adapter<cardViewRecyclerViewAdapter.ViewHolder> {

    private List<String> nData, pData;
    private List<Integer> mImage;
    private Context mContext;
    private LayoutInflater mInflatter;
    private ItemClickListener mClickListener;

    cardViewRecyclerViewAdapter(shop context, List<String> nData, List<String> pData, List<Integer> image_urls) {
        this.mInflatter = LayoutInflater.from(context);
        this.nData = nData;
        this.pData = pData;
        this.mImage = image_urls;
        this.mContext = context;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflatter.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(cardViewRecyclerViewAdapter.ViewHolder holder, int position) {
        String item = nData.get(position);
        String price = pData.get(position);
        Integer image_urls = mImage.get(position);
        holder.myTextView.setText(item + "          $" + price);
        holder.myImageView.setImageResource(image_urls);
    }

    @Override
    public int getItemCount() {
        return nData.size();
    }

    String getItem(int id) {
        return nData.get(id);
    }
    String getPrice(int id) { return pData.get(id); }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView myTextView;
        ImageView myImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvItemName);
            myImageView = itemView.findViewById(R.id.ivAnimal);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view,getAdapterPosition());
            }

        }
    }

    public interface ItemClickListener {
        void onItemClick (View view, int position);
    }
}
