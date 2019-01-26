package com.liuhuan.demo.service.impl;

import com.liuhuan.demo.dao.UserMapper;
import com.liuhuan.demo.entity.User;
import com.liuhuan.demo.repository.UserRepository;
import com.liuhuan.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        //return userRepository.findAll();
        return userMapper.selectAllUser();
    }

    @Override
    public User findUserById(long id) {
        //return userRepository.findById(id);
        //return  userRepository.findById(id);
        return userMapper.selectOneUser(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
