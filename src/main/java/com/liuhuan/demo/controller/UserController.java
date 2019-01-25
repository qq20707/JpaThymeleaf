package com.liuhuan.demo.controller;

import com.liuhuan.demo.entity.User;
import com.liuhuan.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/")
    public String index(){
        return "/index";
    }

//    @RequestMapping("/list")
//////    public String list(Model model){
//////        //查询用户数据
//////        List<User> users = userService.getUserList();
//////        model.addAttribute("users",users);
//////        return "user/list";
//////    }
    @GetMapping
    public ModelAndView list(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
        model.addAttribute("titless","勇士历史");
        return new ModelAndView("user/list","userModel",model);
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }
    @RequestMapping("/add")
    public String add(User user){
        System.out.println("Add sUserName"+user.getUserName());
        System.out.println("Add Password"+user.getPassword());
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        System.out.println("userName:"+user.getUserName());
        System.out.println("Password:" + user.getPassword());
        model.addAttribute("user",user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        System.out.println(user.getUserName()+" ");
        System.out.println(user.getPassword());
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id){
        userService.delete(id);
        return "redirect:/list";
    }
}
