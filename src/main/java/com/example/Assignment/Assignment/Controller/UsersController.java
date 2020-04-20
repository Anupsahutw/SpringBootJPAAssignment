package com.example.Assignment.Assignment.Controller;


import com.example.Assignment.Assignment.Model.Users;
import com.example.Assignment.Assignment.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@RequestMapping(value = "/users")
@RestController
public class UsersController  {

    @Autowired
    UsersService usersService;


    @PostMapping("")
    public Object createUser(@Valid @RequestBody Users users) {

        return  usersService.createUser(users);
    }

    @GetMapping(value = "")
    public List<Users> listUsers() {
        return usersService.listUsers();
    }


}
