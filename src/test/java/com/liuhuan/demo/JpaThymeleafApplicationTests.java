package com.liuhuan.demo;

import com.liuhuan.demo.entity.User;
import com.liuhuan.demo.dao.UserMapper;
import com.liuhuan.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaThymeleafApplicationTests {
    @Resource
    public UserMapper userMapper;
    @Test
    public void contextLoads() {
    }
    @Resource
    private UserService userService;
    @Test
    public void testRespository(){

        User user = new User();
        user.setId(8);
        user.setUserName("贝塔");
        user.setPassword("123467890");
        user.setAge(34);
        userService.save(user);

        List<User> userList = userService.getUserList();
        System.out.println("UserList:"+userList.size());
    }

    @Test
    public void testQuery()throws  Exception{
        List<User> users = userService.getUserList();
        System.out.println(users.toString());
        User user = userMapper.selectOneUser(3L);
        System.out.println("---测试根据ID查询用户信息------");
        System.out.println(user.toString());

    }

}

