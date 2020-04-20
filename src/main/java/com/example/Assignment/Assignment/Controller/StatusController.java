package com.example.Assignment.Assignment.Controller;

import com.example.Assignment.Assignment.Model.Status;
import com.example.Assignment.Assignment.Model.Users;
import com.example.Assignment.Assignment.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;


@RequestMapping(value = "/status")
@RestController
public class StatusController {

    @Autowired
    StatusService statusService;

    @PostMapping("")
    public Object createStatus(@Valid @RequestBody Status status) {

        return  statusService.createStatus(status);
    }

    @GetMapping("")
    public List<Status> listStatus() {

        return statusService.listStatus();
    }
}
