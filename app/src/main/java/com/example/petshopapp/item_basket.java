package com.example.petshopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class item_basket extends AppCompatActivity implements linearViewAdapter.ItemClickListener {

    linearViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_basket);

        ArrayList<String> basketItem = new ArrayList<>();
        basketItem.add("Item 1");
        basketItem.add("Item 2");
        basketItem.add("Item 3");
        basketItem.add("Item 4");
        basketItem.add("Item 5");

        RecyclerView recyclerView = findViewById(R.id.rvBasketItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new linearViewAdapter(this, basketItem);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}