package com.example.borgerkongbyz5210273;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TotalActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_actvity);

        TextView total = findViewById(R.id.total);

        total.setText("Total: $" + String.format("%.2f", FakeDatabase.getOrdersTotal()));

        ArrayList<Food> orders = FakeDatabase.getAllOrders();

        System.out.println(orders.size());

        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new FoodAdapter(this, orders, true));



    }


}
