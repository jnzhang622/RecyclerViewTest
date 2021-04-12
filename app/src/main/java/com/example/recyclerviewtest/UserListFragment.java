package com.example.recyclerviewtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtest.adapter.UserAdapter;

public class UserListFragment extends Fragment {
    UserViewModel mUserViewModel;
    RecyclerView usersRv;
    Button backToForm;

    public UserListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.user_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        usersRv = view.findViewById(R.id.user_list_rv);
        UserAdapter userAdapter = new UserAdapter(mUserViewModel.getAllUsersList());
        usersRv.setAdapter(userAdapter);
        usersRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        backToForm = view.findViewById(R.id.user_list_back_button);

        backToForm.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_user_list_fragment_pop);
        });

    }

}
