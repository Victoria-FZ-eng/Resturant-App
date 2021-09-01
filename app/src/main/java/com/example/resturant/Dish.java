package com.example.resturant;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dish {

   @PrimaryKey
   public int taskId;

   @ColumnInfo(name = "name")
   public String name;

   @ColumnInfo(name = "ingrediants")
   public String ingrediants;

   @ColumnInfo(name = "price")
   public double price;

   public Dish(String name, String ingrediants, double price) {
      this.name = name;
      this.ingrediants = ingrediants;
      this.price = price;
   }
}
