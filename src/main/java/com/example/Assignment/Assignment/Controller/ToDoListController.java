package com.example.Assignment.Assignment.Controller;

import com.example.Assignment.Assignment.Model.Priority;
import com.example.Assignment.Assignment.Model.ToDoList;
import com.example.Assignment.Assignment.Model.Users;
import com.example.Assignment.Assignment.Service.ToDoListService;
import com.example.Assignment.Assignment.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/todolist")
@RestController
public class ToDoListController  {

    @Autowired
    ToDoListService todoService;

    @Autowired
    UsersService usersService;

    @PostMapping("")
    public Object createTodolist(@Valid @RequestBody ToDoList toDoList) {

        return  todoService.createTodolist(toDoList,usersService);
    }

    @GetMapping
    public List<ToDoList> listTodo() {

        return todoService.listTodo();
    }

    @GetMapping(value = "/{userid}")
    public Object getSingleTodolist(@PathVariable int userid) {

        return todoService.getAllTodolistWithUserid(userid,usersService);
    }

    @PutMapping(value = "/{id}")
    public Object updateTodolist(@PathVariable int id, @RequestBody ToDoList toDoList) {
        return todoService.updateTodolist(toDoList,id);
    }

    @DeleteMapping(value = "/{id}")
    public Object deleteTodolist(@PathVariable int id) {

       return todoService.deleteTodolist(id);
    }

    @GetMapping("/userid/{userid}/priorityorder/{priorityorder}/")
    public Object todoListByPriorityOrder(@PathVariable int userid,@PathVariable int priorityorder) {

        return todoService.getTodolistByPriorityOrder(userid,priorityorder,usersService);
    }

    @GetMapping("/userid/{userid}/priorityorder/asc")
    public Object sortByPriorityOrderAscending(@PathVariable int userid) {

        return todoService.sortTodolistByPriorityOrderAsc(userid,usersService);
    }

    @GetMapping("/userid/{userid}/priorityorder/desc")
    public Object sortByPriorityOrderDescending(@PathVariable int userid) {

        return todoService.sortTodolistByPriorityOrderDesc(userid,usersService);
    }

    @GetMapping("/userid/{userid}/statusorder/{statusorder}/")
    public Object todoListByStatusOrder(@PathVariable int userid,@PathVariable int statusorder) {
        return todoService.getTodolistByStatusOrder(userid,statusorder,usersService);
    }

    @GetMapping("/userid/{userid}/betweendate")
    public Object getTodolistBetweenDate
            (@PathVariable int userid,
             @RequestParam(name = "startdate",required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDateAndTime,
             @RequestParam(name = "enddate",required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)Date endDateAndTime) {

        return  todoService.todolistBetweenDates(userid,startDateAndTime, endDateAndTime,usersService);
    }
}
