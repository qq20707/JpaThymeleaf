package com.liuhuan.demo;

import com.liuhuan.demo.entity.User;
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

    @Test
    public void contextLoads() {
    }
    @Resource
    private UserService userService;
    @Test
    public void testRespository(){

        User user = new User();
        user.setId(6);
        user.setUserName("贝塔");
        user.setPassword("123467890");
        user.setAge(34);
        userService.save(user);

        List<User> userList = userService.getUserList();
        System.out.println("UserList:"+userList.size());
    }

}

