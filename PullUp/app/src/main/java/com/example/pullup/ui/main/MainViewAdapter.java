package com.example.pullup.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pullup.R;
import com.example.pullup.databinding.MainItemBinding;
import com.example.pullup.entity.MainItem;
import com.example.pullup.ui.common.BindingViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainViewAdapter extends RecyclerView.Adapter<BindingViewHolder<MainItemBinding>> {
    private ArrayList<MainItem> mainItemArrayList = null;
    private OnAddItemListener addItemListener = null;

    public interface OnAddItemListener {
        void onAddItem();
    }

    public void setOnAddItemListener(OnAddItemListener listener) {
        this.addItemListener = listener;
    }

    public void setItem(ArrayList<MainItem> itemList) {
        if (itemList != null) {
            mainItemArrayList = null;
            mainItemArrayList = itemList;
            notifyDataSetChanged();
        }
    }

    public MainItem getItem(int position) {
        return mainItemArrayList.get(position);
    }

    @NonNull
    @NotNull
    @Override
    public BindingViewHolder<MainItemBinding> onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new BindingViewHolder<>(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BindingViewHolder<MainItemBinding> holder, int position) {
        final MainItem item = getItem(position);
        holder.getBinding().setData(item);
        holder.getBinding().executePendingBindings();
        if (position == getItemCount() - 1) {
            addItemListener.onAddItem();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
