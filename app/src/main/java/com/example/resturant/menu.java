package com.example.resturant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class menu extends AppCompatActivity {

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    protected void onStart(){
        super.onStart();

        Button home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        appDatabase =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "dishDatabase").allowMainThreadQueries()
                .build();
        List<Dish> allDishes =appDatabase.dishDao().getAll();

        RecyclerView allDishesRecyclerView = findViewById(R.id.recyclerView);

        allDishesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        allDishesRecyclerView.setAdapter(new DishAdapter(allDishes));

    }
}