package com.example.pullup.ui.common;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pullup.entity.MainItem;
import com.example.pullup.ui.main.MainViewAdapter;

import java.util.ArrayList;

public class Binder {
   @BindingAdapter({"android:src"})
   public static void setImageViewResource(ImageView imageView, int resource) {
       imageView.setImageResource(resource);
   }
   @BindingAdapter(value = {"itemList", "addItem"}, requireAll = false)
    public static void bindItemList(RecyclerView recyclerView, ArrayList<MainItem> itemList, MainViewAdapter.OnAddItemListener addItemListener) {
       MainViewAdapter adapter;
       if(recyclerView.getAdapter() == null) {
           adapter = new MainViewAdapter();
           recyclerView.setAdapter(adapter);
       } else {
           adapter = (MainViewAdapter) recyclerView.getAdapter();
       }
       adapter.setItem(itemList);
       adapter.setOnAddItemListener(addItemListener);
   }
}
