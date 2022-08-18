package com.example.petshopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class basket_cardViewAdapter extends RecyclerView.Adapter<basket_cardViewAdapter.ViewHolder> {

    private List<String> nData;
    private List<Integer> pData;
    private Context mContent;
    private LayoutInflater mInflatter;
    private ItemClickListener mClickListener;

    basket_cardViewAdapter(basket context, List<String> nData, List<Integer> pData ) {
        this.mInflatter = LayoutInflater.from(context);
        this.nData = nData;
        this.pData = pData;
        mContent = context;
    }

    void setClickListener(basket itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflatter.inflate(R.layout.basket_cardview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( basket_cardViewAdapter.ViewHolder holder, int position) {
        String item = nData.get(position);
        int price = pData.get(position);
        holder.myTextViewName.setText(item);
        holder.myTextViewPrice.setText(Integer.toString(price));
    }

    @Override
    public int getItemCount() {
        return nData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextViewName, myTextViewPrice;

        ViewHolder(View itemView) {
            super(itemView);
            myTextViewName = itemView.findViewById(R.id.tvBasketItemName);
            myTextViewPrice = itemView.findViewById(R.id.tvBasketItemPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }

        }

    }

    String getItem(int id) { return nData.get(id); }

    public interface ItemClickListener {
        void onItemClick (View view, int position);
    }
}
