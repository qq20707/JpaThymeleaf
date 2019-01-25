package com.liuhuan.demo.service;

import com.liuhuan.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User findUserById(long id);

    void save(User user);

    void edit(User user);

    void delete(long id);

}
