package com.example.Assignment.Assignment.Service;

import com.example.Assignment.Assignment.Handler.ResponseHandler;
import com.example.Assignment.Assignment.Model.Users;
import com.example.Assignment.Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService extends ResponseHandler {

    @Autowired
    UserRepository userRepository;

    public Object createUser(Users users) {

        //Users userExists = findById(users.getId());
          Users existingUsername = findByUsername(users.getUsername());

          if (existingUsername != null) {
                return duplicateEntryResponseEntity("User name already exists");
          }

        return userRepository.save(users);
    }

    public List<Users> listUsers() {
        List<Users> employees = userRepository.findAll();
        return employees;
    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    public Users findById(int id) {
        return  userRepository.findById(id);
    }

}
