package com.example.resturant;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter  extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {
    AppDatabase appDatabase;

    List<Dish> allDishes =new ArrayList<>();

    public DishAdapter(List<Dish> allDishes) {
        this.allDishes = allDishes;
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder{

        public Dish dish;
        View itemView;

        public DishViewHolder(@NonNull View itemView)  {
            super(itemView);
            this.itemView=itemView;

            itemView.findViewById(R.id.menuItemFrag).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("after");
                    Intent intent = new Intent(v.getContext(),dishDetails.class);

                    intent.putExtra("name",dish.name);
                    intent.putExtra("ing",dish.ingrediants);
                    intent.putExtra("price",dish.price);
                    // Toast.makeText(v.getContext(),"check Dish Ingredients",Toast.LENGTH_LONG).show();

                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    @NotNull
    @Override
    public DishViewHolder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish,parent,false);
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NotNull DishViewHolder holder, int position) {
        holder.dish = allDishes.get(position);

        TextView menuItem = holder.itemView.findViewById(R.id.menuItemFrag);
        String x = "Dish: "+holder.dish.name+" - price: "+holder.dish.price;
        menuItem.setText(x);

    }

    @Override
    public int getItemCount() {
        return allDishes.size();
    }


}
