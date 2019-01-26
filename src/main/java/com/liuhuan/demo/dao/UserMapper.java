package com.liuhuan.demo.dao;

import com.liuhuan.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
        List<User> selectAllUser();
        User selectOneUser(Long id);
}
