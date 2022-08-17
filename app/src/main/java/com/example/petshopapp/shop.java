package com.example.petshopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class shop extends AppCompatActivity implements cardViewRecyclerViewAdapter.ItemClickListener {

    cardViewRecyclerViewAdapter adapter;
    Button checkout_button;

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
        itemNames.add("Bird Food");

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

        ArrayList<Integer> itemImages=new ArrayList<Integer>();

        itemImages.add(R.drawable.dog_food);
        itemImages.add(R.drawable.fish_food);
        itemImages.add(R.drawable.rabbit_food);
        itemImages.add(R.drawable.mice_food);
        itemImages.add(R.drawable.duck_food);
        itemImages.add(R.drawable.cat_food);
        itemImages.add(R.drawable.chick_food);
        itemImages.add(R.drawable.goose_food);
        itemImages.add(R.drawable.alpacas_food);
        itemImages.add(R.drawable.bird_food);

        RecyclerView recyclerView = findViewById(R.id.rvStore);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));

        adapter = new cardViewRecyclerViewAdapter(this, itemNames, itemPrices, itemImages);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        checkout_button = findViewById(R.id.rvCheckoutButton);
        checkout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkoutPage = new Intent(shop.this, item_basket.class);
                startActivity(checkoutPage);
            }
        });

    }

    public void onItemClick (View view, int position) {
        Toast.makeText(this, "You Click" + adapter.getItem(position) +
                " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}