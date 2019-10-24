package com.example.borgerkongbyz5210273;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Page2DetailActivity extends AppCompatActivity {
    private TextView foodName;
    private TextView foodDes;
    private ImageView foodImage;
    private TextView foodPrice;
    private Number quantity;
    public static int foodID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2_detail);

        //get value(foodID) from intent which was located in the adapter
        Intent intent = getIntent();

        this.foodID = intent.getIntExtra("FoodID", 0);

        Food food = FakeDatabase.getFoodById(foodID);

        foodName = findViewById(R.id.foodName);
        foodDes = findViewById(R.id.foodDes);
        foodImage = findViewById(R.id.foodImage);
        foodPrice = findViewById(R.id.foodPrice);

        foodName.setText(food.getFoodName());
        foodPrice.setText("$" + Double.toString(food.getFoodPrice()));
        foodDes.setText(food.getFoodSummary());
        foodImage.setImageResource(food.getImageDrawableId());


        Button minus_button = findViewById(R.id.minusItem);
        Button plus_button = findViewById(R.id.plusItem);
        Button add = findViewById(R.id.addToCart);

        final TextView amount = findViewById(R.id.quantity);

        minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(amount.getText().toString());

                if (i > 0) {
                    amount.setText(String.valueOf(i - 1));
                }

                FakeDatabase.minus_one(Page2DetailActivity.foodID);

            }
        });

        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = Integer.parseInt(amount.getText().toString());

                amount.setText(String.valueOf(i + 1));

                FakeDatabase.add_one(Page2DetailActivity.foodID);

            }
        });

    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View v) {

        toastMsg("THIS HAS BEEN ADDED TO YOUR ORDER!");

    }




    }
