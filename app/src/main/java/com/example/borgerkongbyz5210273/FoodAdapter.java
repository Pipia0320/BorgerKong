package com.example.borgerkongbyz5210273;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    //Adapter need an arrayList to get info
    //Use inflater to fill data into recycler view
    private ArrayList<Food> foods;
    private LayoutInflater inflater;
    private boolean quant;

    public FoodAdapter(Context context, ArrayList<Food> foods, boolean quant) {
        this.foods = foods;
        this.inflater = LayoutInflater.from(context);
        this.quant = quant;
    }

    @NonNull
    @Override
    //inflate recycler_row
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Food food = this.foods.get(position);

        TextView item_name = holder.itemView.findViewById(R.id.item_name);
        TextView item_price = holder.itemView.findViewById(R.id.item_price);
        ImageView item_image = holder.itemView.findViewById(R.id.item_image);

        item_name.setText(food.getFoodName());


        if (this.quant) {
            item_price.setText("$" + Double.toString(food.getFoodPrice()) + " x "+String.valueOf(food.getQuantity()));
        } else {
            item_price.setText("$" + Double.toString(food.getFoodPrice()));
        }


        item_image.setImageResource(food.getImageDrawableId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Page2DetailActivity.class);

                //identify what user click
                intent.putExtra("FoodID", food.getFoodID());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
