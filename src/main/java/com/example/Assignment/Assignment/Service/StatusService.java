package com.example.Assignment.Assignment.Service;

import com.example.Assignment.Assignment.Model.Priority;
import com.example.Assignment.Assignment.Model.Status;

import com.example.Assignment.Assignment.Model.Users;
import com.example.Assignment.Assignment.Repository.StatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public Object createStatus(Status status) {
        Status existingStatus = findByStatusname(status.getStatusname());
        if (existingStatus != null ) {
            HashMap<String,Object> map = new HashMap<>();
            map.put("error","status name already exists");
            map.put("status","400");
            return map;
        }

        Status existingStatusOrder = findByStatusorder(status.getStatusorder());
        if (existingStatusOrder != null ) {
            HashMap<String,Object> map = new HashMap<>();
            map.put("error","status order already exists");
            map.put("status","400");
            return map;
        }

        return statusRepository.save(status);
    }

    public List<Status> listStatus() {
        List<Status> statuses = statusRepository.findAll();
        return statuses;
    }

    public Status findByStatusname(String statusname) {
        return statusRepository.findByStatusname(statusname);
    }

    public Status findByStatusorder(int statusorder) {
        return statusRepository.findByStatusorder(statusorder);
    }
}
