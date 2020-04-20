package com.example.Assignment.Assignment.Repository;

import com.example.Assignment.Assignment.Model.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ToDoListRepository extends  JpaRepository<ToDoList, Integer>{

    @Query("select t from ToDoList t where t.userid = :userid")
    List<ToDoList> findByUseridAllTodolist(@Param("userid") int userid);

    @Query("select t from ToDoList t where t.id = :id")
    ToDoList findByidTodolist(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("update ToDoList t set t.todoname = :todoname, " +
            "t.todotime = :todotime, " +
            "t.priorityorder = :priorityorder, " +
            "t.statusorder = :statusorder " +
            "where t.id = :id")
    void updateTodolistByUserid(@Param("todoname") String todoname,
                                @Param("todotime") Timestamp todotime,
                                @Param("priorityorder") int priorityorder,
                                @Param("statusorder") int statusorder,
                                @Param("id") int id);

    @Modifying
    @Transactional
    @Query("delete from ToDoList t where t.id = :id")
    int deleteTodolistByUserid(@Param("id") int id);

    @Transactional
    @Query("select t from ToDoList t where t.userid = :userid AND t.priorityorder = :priorityorder")
    List<ToDoList> findByUserIdPriorityorder(@Param("userid") int userid,
                                             @Param("priorityorder") int priorityorder);

    @Transactional
    @Query("select t from ToDoList t where t.userid = :userid AND t.statusorder = :statusorder")
    List<ToDoList> findByUserIdStatusorder(@Param("userid") int userid,
                                             @Param("statusorder") int statusorder);


    @Modifying
    @Transactional
    @Query("select t from ToDoList t where t.userid = :userid and " +
            "t.todotime between :startDateAndTime and :endDateAndTime")
    List<ToDoList> findTodolistByTodotimeBetween(@Param("userid") int userid,
                                                 @Param("startDateAndTime")Date startDateAndTime,
                                                 @Param("endDateAndTime")Date endDateAndTime);

    @Query("select t from ToDoList t INNER JOIN Priority p ON " +
            "t.priorityorder = p.priorityorder AND t.userid = :userid ORDER BY p.priorityorder ASC")
    List<ToDoList> findAllByPriorityAcendingOrderAndUserId(@Param("userid") int userid);


    @Query("select t from ToDoList t INNER JOIN Priority p ON " +
            "t.priorityorder = p.priorityorder AND t.userid = :userid ORDER BY p.priorityorder DESC")
    List<ToDoList> findAllByPriorityDecendingOrderAndUserId(@Param("userid") int userid);
}
