package com.skydevilk.networkhealthcheck.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.skydevilk.networkhealthcheck.R;
import com.skydevilk.networkhealthcheck.databinding.MainFragmentBinding;


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
        getViewLifecycleOwner().getLifecycle().addObserver(viewModel);
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