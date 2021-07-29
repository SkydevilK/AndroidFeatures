package com.example.pullup.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pullup.R;
import com.example.pullup.databinding.MainFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getViewModelStore(), new MainViewModelFactory(requireActivity().getApplication())).get(MainViewModel.class);
        getLifecycle().addObserver(viewModel);
        MainFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.toast.observe(getViewLifecycleOwner(), s -> {
            if (!s.equals("")) {
                Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
        return binding.getRoot();
    }
}