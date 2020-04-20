package com.example.Assignment.Assignment.Service;

import com.example.Assignment.Assignment.Handler.ResponseHandler;
import com.example.Assignment.Assignment.Model.Priority;
import com.example.Assignment.Assignment.Model.ToDoList;

import com.example.Assignment.Assignment.Repository.ToDoListRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService extends ResponseHandler {

    @Autowired
    ToDoListRepository toDoListRepository;

    public Object createTodolist(ToDoList toDoList,UsersService usersService) {

        boolean userIdExists = isUserIdExists(toDoList.getUserid(),usersService);

        if (userIdExists == false) {
            return userNotFoundResponseEntity();
        }

        return toDoListRepository.save(toDoList);
    }

    public List<ToDoList> listTodo() {
        List<ToDoList> toDoLists = toDoListRepository.findAll();
        return toDoLists;
    }

    public Object getAllTodolistWithUserid(int userid, UsersService usersService) {

        boolean userIdExists = isUserIdExists(userid,usersService);

        if (userIdExists == false) {
            return userNotFoundResponseEntity();
        }

        List<ToDoList> toDoLists = toDoListRepository.findByUseridAllTodolist(userid);
        return toDoLists;
    }


    public Object updateTodolist(ToDoList toDoList, int id) {
        ToDoList todolistId = toDoListRepository.findByidTodolist(id);

        if (todolistId == null) {
                return badRequestErrorResponseEntity("Id not found");

        }
        toDoListRepository.updateTodolistByUserid(
                toDoList.getTodoname(),
                toDoList.getTodotime(),
                toDoList.getPriorityorder(),
                toDoList.getStatusorder(),
                id);

        return  toDoListRepository.findByidTodolist(id);
    }

    public Object deleteTodolist(int id) {

        ToDoList todolistId = toDoListRepository.findByidTodolist(id);

        if (todolistId == null) {
            return badRequestErrorResponseEntity("Id not found");

        }

        int result = toDoListRepository.deleteTodolistByUserid(id);
        if (result == 1) {
            return successResponseEntity();
        }else {
            return badRequestErrorResponseEntity("something went wrong");
        }

    }

    public Object getTodolistByPriorityOrder(int userid,int priorityorder, UsersService usersService) {

        boolean userIdExists = isUserIdExists(userid,usersService);

        if (userIdExists == false) {
            return userNotFoundResponseEntity();
        }

        List<ToDoList> toDoLists = toDoListRepository.findByUserIdPriorityorder(userid,priorityorder);

        if (toDoLists.isEmpty()) {
            return successResponseEntity("No Todo list found with given priority order");
        }
        return toDoLists;
    }

    public Object sortTodolistByPriorityOrderAsc(int userid, UsersService usersService) {
        boolean userIdExists = isUserIdExists(userid,usersService);

        if (userIdExists == false) {
            return userNotFoundResponseEntity();
        }


       // Sort.Order order = new Sort.Order(Direction.ASC,"priorityorder");
        // List<ToDoList> toDoLists = toDoListRepository.findAll(Sort.by(order));

        List<ToDoList> toDoLists = toDoListRepository.findAllByPriorityAcendingOrderAndUserId(userid);
        return toDoLists;
    }

    public Object sortTodolistByPriorityOrderDesc(int userid, UsersService usersService) {
        boolean userIdExists = isUserIdExists(userid,usersService);

        if (userIdExists == false) {
            return userNotFoundResponseEntity();
        }

       // Sort.Order order = new Sort.Order(Direction.DESC,"priorityorder");
       // List<ToDoList> toDoLists = toDoListRepository.findAll(Sort.by(order));

        List<ToDoList> toDoLists = toDoListRepository.findAllByPriorityDecendingOrderAndUserId(userid);
        return toDoLists;
    }

    public Object getTodolistByStatusOrder(int userid,int statusorder, UsersService usersService) {

        boolean userIdExists = isUserIdExists(userid,usersService);

        if (userIdExists == false) {
            return userNotFoundResponseEntity();
        }
        List<ToDoList> toDoLists = toDoListRepository.findByUserIdStatusorder(userid,statusorder);

        if (toDoLists.isEmpty()) {
            return successResponseEntity("No Todo list found with given status order");
        }
        return toDoLists;
    }

    public Object todolistBetweenDates(int userid,Date startDateAndTime, Date endDateAndTime,UsersService usersService) {
        boolean userIdExists = isUserIdExists(userid,usersService);

        if (userIdExists == false) {
            return userNotFoundResponseEntity();
        }

        List<ToDoList> toDoLists = toDoListRepository.findTodolistByTodotimeBetween(userid,startDateAndTime,endDateAndTime);
        return  toDoLists;
    }
}
