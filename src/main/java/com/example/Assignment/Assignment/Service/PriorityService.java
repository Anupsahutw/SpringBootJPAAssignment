package com.example.Assignment.Assignment.Service;

import com.example.Assignment.Assignment.Model.Priority;

import com.example.Assignment.Assignment.Repository.PriorityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    @Autowired
    PriorityRepository priorityRepository;


    public Priority createPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public List<Priority> listPriority() {
        List<Priority> priorities = priorityRepository.findAll();
        return priorities;
    }

//    public List<Priority> listPriorityByPriorityOrder() {
//        List<Priority> priorities = priorityRepository.fin
//    }
}
