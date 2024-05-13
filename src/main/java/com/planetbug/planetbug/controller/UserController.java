package com.planetbug.planetbug.controller;


import com.planetbug.planetbug.dto.User;
import com.planetbug.planetbug.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    private HttpSession session;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String defaultMessage(){
        return "hi";
    }

    @PostMapping("login")
    public String loginUser(@RequestBody User user){
        if(user.getUsername().equals("")){
            // username란이 공란임
            return "1";
        }

        Integer result = userService.selectUserByUserName(user);

        return String.valueOf(result);
    }

    @PostMapping("insertUser")
    public String createUser(@RequestBody User user){

        if(user.getEmail().equals("")){
            // email 란이 공란임
            return "2";
        }else if(user.getUsername().equals("")){
            // username란이 공란임
            return "1";
        }

        Integer result = userService.createUser(user);

        return String.valueOf(result);
    }

}
