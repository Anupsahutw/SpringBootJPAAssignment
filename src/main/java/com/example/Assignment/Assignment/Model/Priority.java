package com.example.Assignment.Assignment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "priority")
@Data
public class Priority {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Min(1)
    @Max(3)
    @Column(name = "priorityorder", nullable = false, unique = true)
    private int priorityorder;

    @NotNull(message = "Priority Name cannot be null")
    @NotEmpty(message = "Please provide priority name")
    @Column(name = "priorityname", nullable = false, unique = true)
    private String priorityname;

    public Priority(int priorityorder ,String priorityname) {
        this.priorityorder = priorityorder;
        this.priorityname = priorityname;
    }

    public Priority() {

    }
}
