package com.skydevilk.networkhealthcheck.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    public MutableLiveData<String> toast = new MutableLiveData<>("");

    public MainViewModel(@NonNull @NotNull Application application) {
        super(application);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    public void onRefresh() {
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