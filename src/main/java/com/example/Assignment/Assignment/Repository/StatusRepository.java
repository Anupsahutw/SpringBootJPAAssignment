package com.example.Assignment.Assignment.Repository;

import com.example.Assignment.Assignment.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findByStatusname(String statusname);

    Status findByStatusorder(int statusorder);
}
