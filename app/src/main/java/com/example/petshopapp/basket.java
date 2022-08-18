package com.example.petshopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class basket extends AppCompatActivity implements basket_cardViewAdapter.ItemClickListener {

    basket_cardViewAdapter adapter;
    TextView name, prices;

    ArrayList<String> basketItemNames = new ArrayList<>();
    ArrayList<Integer> basketItemPrices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        basket_dbHandler db = new basket_dbHandler(this);
        ArrayList<HashMap<String, String>> itemList = db.GetItems();

        name = (TextView)findViewById(R.id.tvBasketItemName);
        prices = (TextView)findViewById(R.id.tvBasketItemPrice);



        RecyclerView recyclerView = findViewById(R.id.rvBasketItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new basket_cardViewAdapter(this, basketItemNames, basketItemPrices);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

    }
}