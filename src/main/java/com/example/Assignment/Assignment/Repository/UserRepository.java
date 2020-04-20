package com.example.Assignment.Assignment.Repository;

import com.example.Assignment.Assignment.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends  JpaRepository<Users, Integer> {

    Users findByUsername(String username);

    @Query("select u from Users u where u.id = :id")
    Users findById(@Param("id")int id);
}
