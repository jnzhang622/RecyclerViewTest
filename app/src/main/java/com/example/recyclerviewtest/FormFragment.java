package com.example.recyclerviewtest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyclerviewtest.databinding.FormFragmentBinding;

public class FormFragment extends Fragment {
    FormFragmentBinding binding;
    private UserViewModel mUserViewModel;

    EditText etName;
    EditText etPhone;
    Button saveButton;
    Button showListButton;

    public FormFragment() {
        // Required empty public constructor
    }
    public static FormFragment newInstance() {
        return new FormFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.form_fragment, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        etName = getView().findViewById(R.id.name_field_input);
        etPhone = getView().findViewById(R.id.phone_field_input);
        saveButton = getView().findViewById(R.id.save_button);
        showListButton = getView().findViewById(R.id.show_list);

        saveButton.setOnClickListener(v -> {
            mUserViewModel.createUser(
                    etName.getText().toString(),
                    etPhone.getText().toString()
            );
        });
        showListButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.user_list_fragment);
        });

        mUserViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
    }
}