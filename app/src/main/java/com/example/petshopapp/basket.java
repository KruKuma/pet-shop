package com.example.petshopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class basket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        basket_dbHandler db = new basket_dbHandler(this);
        ArrayList<HashMap<String, String>> itemList = db.GetItems();

        ListView lv = (ListView) findViewById(R.id.item_list);
        ListAdapter adapter = new SimpleAdapter(basket.this, itemList, R.layout.list_row,
                new String[]{"name", "price"},
                new int[]{R.id.lvItemName, R.id.lvItemPrice});

        lv.setAdapter(adapter);


    }
}