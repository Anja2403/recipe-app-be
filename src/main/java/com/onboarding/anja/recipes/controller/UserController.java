package com.onboarding.anja.recipes.controller;

import com.onboarding.anja.recipes.entity.UserEntity;
import com.onboarding.anja.recipes.projections.CreateUserProjection;
import com.onboarding.anja.recipes.projections.LoginUserProjection;
import com.onboarding.anja.recipes.projections.UserProjection;
import com.onboarding.anja.recipes.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserProjection> findAll() {
        return userService.findAll();
    }

//    @PostMapping("/new")
//    public void createNewUser(@RequestBody CreateUserProjection request) {
//        userService.createNewUser(request);
//    }

    @PostMapping("/new")
    public UserProjection createNewUser(@RequestBody CreateUserProjection request) {
       return userService.createNewUser(request);
    }

    @GetMapping("/{id}")
    public UserProjection getById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping
    public UserProjection updateUser(@RequestBody UserProjection request) {
       return userService.updateUser(request);
    }

    @GetMapping
    public List<UserProjection> findAllUser() {
        return userService.findAllUser();
    }

    @PostMapping
    public UserProjection loginUser(@RequestBody LoginUserProjection request) {
        return userService.login(request);
    }
}
