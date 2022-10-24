package org.example.MyProject_SpringBoot.service;

import org.example.MyProject_SpringBoot.model.User;
import org.example.MyProject_SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void addUser(User user) {

        userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); //
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void removeUser(int id) {

        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {

        User userId = userRepository.findById(id).get();
        userId.setLastName(user.getLastName());
        userId.setName(user.getName());
        userRepository.save(userId);
    }
}
