package com.example.Assignment.Assignment.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Table(name = "todolist")
@Data
public class ToDoList {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull(message = "todoname cannot be null")
    @NotEmpty(message = "Please provide todo name")
    @Column(name = "todoname", nullable = false)
    private String todoname;

    //@NotNull(message = "Time cannot be null")
    //@NotEmpty(message = "Please provide todo time")
    @Column(name = "todotime", nullable = false)
    private Timestamp todotime;

   // @NotNull(message = "user id cannot be null")
    //@NotEmpty(message = "Please provide user id")
    @Column(name = "userid", nullable = false)
    private int userid;

    //@NotNull(message = "priority order cannot be null")
    //@NotEmpty(message = "Please provide priority order")
    @Column(name = "priorityorder", nullable = false)
    private int priorityorder;

    //@NotNull(message = "status order cannot be null")
   // @NotEmpty(message = "Please provide status order")
    @Column(name = "statusorder", nullable = false)
    private int statusorder;

    /*
    @Basic(optional = false)
    @Column(name = "todotime", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date todotime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private Priority priority;
*/
    public ToDoList() {
    }

    public ToDoList(String todoname,Timestamp todotime,int userid,int priorityorder,int statusorder) {
        this.todoname = todoname;
        this.todotime = todotime;
        this.userid = userid;
        this.priorityorder = priorityorder;
        this.statusorder = statusorder;
    }


}
