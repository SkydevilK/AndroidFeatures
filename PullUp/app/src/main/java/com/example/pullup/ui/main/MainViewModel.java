package com.example.pullup.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.pullup.entity.MainItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    public MutableLiveData<String> toast = new MutableLiveData<>("");
    public MutableLiveData<ArrayList<MainItem>> itemList = new MutableLiveData<>();
    public MainViewAdapter.OnAddItemListener addItemListener;
    public ArrayList<MainItem> list = new ArrayList<>();
    public int totalCount;

    public MainViewModel(@NonNull @NotNull Application application) {
        super(application);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        addItemListener = () -> {
            if (totalCount > list.size())
                getData();
        };
    }

    public void onRefresh() {
        isLoading.setValue(true);
        itemList.postValue(list);
        isLoading.setValue(false);
    }

    public void getData() {

    }
}

class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @NonNull
    @NotNull
    private final Application application;

    MainViewModelFactory(@NonNull @NotNull Application application) {
        this.application = application;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass == MainViewModel.class) {
            return (T) new MainViewModel(application);
        }
        return null;
    }
}