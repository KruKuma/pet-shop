package com.example.petshopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class shop extends AppCompatActivity implements cardRecyclerViewAdapter.ItemClickListener {

    cardRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ArrayList<String> itemNames = new ArrayList<>();
        itemNames.add("Dog Food");
        itemNames.add("Fish Food");
        itemNames.add("Rabbit Food");
        itemNames.add("Mice Food");
        itemNames.add("Duck Food");
        itemNames.add("Cat Food");
        itemNames.add("Chicken Food");
        itemNames.add("Goose Food");
        itemNames.add("Alpaca Food");
        itemNames.add("Turkey Food");

        ArrayList<String> itemPrices = new ArrayList<>();
        itemPrices.add("12");
        itemPrices.add("13");
        itemPrices.add("11");
        itemPrices.add("16");
        itemPrices.add("17");
        itemPrices.add("15");
        itemPrices.add("14");
        itemPrices.add("18");
        itemPrices.add("19");
        itemPrices.add("21");

        ArrayList<Integer> itemImageUrls = new ArrayList<>();
        itemImageUrls.add(R.drawable.cow);
        itemImageUrls.add(R.drawable.dog);
        itemImageUrls.add(R.drawable.dolphin);
        itemImageUrls.add(R.drawable.goat);
        itemImageUrls.add(R.drawable.horse);
        itemImageUrls.add(R.drawable.rooster);
        itemImageUrls.add(R.drawable.unicorn);
        itemImageUrls.add(R.drawable.wolf);

        RecyclerView recyclerView = findViewById(R.id.rvStore);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);

        adapter = new cardRecyclerViewAdapter(this, itemNames, itemPrices, itemImageUrls);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void onItemClick (View view, int position) {
        Toast.makeText(this, "You Click" + adapter.getItem(position) +
                " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}