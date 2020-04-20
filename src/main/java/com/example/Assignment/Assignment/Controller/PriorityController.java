package com.example.Assignment.Assignment.Controller;


import com.example.Assignment.Assignment.Model.Priority;
import com.example.Assignment.Assignment.Model.Users;
import com.example.Assignment.Assignment.Service.PriorityService;
import com.example.Assignment.Assignment.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/priority")
@RestController
public class PriorityController {
    @Autowired
    PriorityService priorityService;

    @PostMapping("")
    public Priority createPriority(@Valid @RequestBody Priority priority) {
        return  priorityService.createPriority(priority);
    }

    @GetMapping("")
    public List<Priority> listPriority() {

        return priorityService.listPriority();
    }

}
