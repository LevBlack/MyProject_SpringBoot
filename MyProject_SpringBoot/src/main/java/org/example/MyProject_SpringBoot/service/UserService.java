package org.example.MyProject_SpringBoot.service;


import org.example.MyProject_SpringBoot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUser(int id);

    List<User> getAllUsers();

    void removeUser(int id);

}
