package com.example.pullup.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    public MutableLiveData<String> toast = new MutableLiveData<>("");

    public void onRefresh() {
        toast.setValue(isLoading.getValue().toString());
        isLoading.setValue(false);
    }
}