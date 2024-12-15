package com.ideanet.test_flyway.controller;

import com.ideanet.test_flyway.domain.User;
import com.ideanet.test_flyway.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> all(){
        return userService.getUsers();
    }

    @GetMapping("/all/{name}")
    public List<User> all(@PathVariable String name){
        return userService.getUsersByName(name);
    }

    @GetMapping("/{userId}")
    public User id(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/new")
    public User create(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public String delete(@PathVariable Long userId){
        userService.deleteUser(userId);
        return userId.toString();
    }

}
