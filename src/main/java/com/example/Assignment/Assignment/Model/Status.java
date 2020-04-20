package com.example.Assignment.Assignment.Model;

import lombok.Data;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "status")
@Data

public class Status {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Min(1)
    @Max(2)
    @Column(name = "statusorder", nullable = false, unique = true)
    private int statusorder;

    @NotNull(message = "Status Name cannot be null")
    @NotEmpty(message = "Please provide status name")
    @Column(name = "statusname", nullable = false, unique = true)
    private String statusname;

    public Status(int statusorder ,String statusname) {
        this.statusorder = statusorder;
        this.statusname = statusname;
    }

    public Status() {

    }
}
