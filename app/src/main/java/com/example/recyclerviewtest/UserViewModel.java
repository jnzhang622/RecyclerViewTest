package com.example.recyclerviewtest;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {

    ArrayList<User> allUsersList = new ArrayList<>();

    public void createUser(@NonNull String name, @NonNull String phone) {
        User newUser = new User();

        newUser.setName(name);
        newUser.setPhone(phone);

        allUsersList.add(newUser);
    }

    public ArrayList<User> getAllUsersList() {
        return allUsersList;
    }
}