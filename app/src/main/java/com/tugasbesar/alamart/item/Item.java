package com.tugasbesar.alamart.item;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Item {

    public String name;
    public String description;
    public String maker;
    public ArrayList<String> category;
    public int size;
    public double price;
    public int stock;
    public int discount;

    public Item(String name, String description, String maker, ArrayList<String> category, int size, double price, int stock, int discount) {
        this.name = name;
        this.description = description;
        this.maker = maker;
        this.category = category;
        this.size = size;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPrice() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setMaximumFractionDigits(0);
        return numberFormat.format(this.price);
    }

    public double getPriceInt() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addCategory(String s) {
        this.category.add(s);
    }

    public void removeCategory(String s) {
        this.category.remove(s);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @BindingAdapter("showDiscount")
    public static void setDiscount(LinearLayout view, int discount) {
        if (discount > 0) {
            view.setVisibility(View.VISIBLE);
        }
    }

    @BindingAdapter({"bind:discount", "bind:price"})
    public static void setDiscountedPrice(TextView view, int discount, double price) {
        if (discount > 0) {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            numberFormat.setMaximumFractionDigits(0);
            view.setText(numberFormat.format(price - (price * discount / 100)));
        }
    }

}
