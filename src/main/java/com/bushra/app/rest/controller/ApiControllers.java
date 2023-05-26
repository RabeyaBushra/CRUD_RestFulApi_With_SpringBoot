package com.bushra.app.rest.controller;

import com.bushra.app.rest.Repo.UserRepo;

import com.bushra.app.rest.model.User;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController

public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "welcome";
    }

    @GetMapping(value = "/users")
     public List<User> getUsers(){

        return  userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user)
    {
        userRepo.save(user);
        return "saved all info .....";
    }

    @PutMapping (value = "/update/{id}")
    public String updateUser(@PathVariable long id , @RequestBody User user)
    {
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirst_Name(user.getFirst_Name());
        updateUser.setLast_Name(user.getLast_Name());
        updateUser.setOccupation(user.getOccupation());
        updateUser.setAge(user.getAge());
        userRepo.save(updateUser);
        return "updated";


    }
    @DeleteMapping (value = "/delete/{id}")
    public String deleteuser(@PathVariable long id)
    {
        User deleteUser=userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "deleted id :  "+id;
    }

}
