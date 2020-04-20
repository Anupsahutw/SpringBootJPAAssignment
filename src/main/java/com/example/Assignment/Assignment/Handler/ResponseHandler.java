package com.example.Assignment.Assignment.Handler;



import com.example.Assignment.Assignment.Model.Users;
import com.example.Assignment.Assignment.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResponseHandler {

    private static final String USER_NOTFOUND = "User id doesn't exists";

    protected boolean isUserIdExists(int userId,UsersService usersService) {
        try {
            Users existsUserid = usersService.findById(userId);
            if (userId == existsUserid.getId()) {
                return true;
            }
            return false;
        }catch(RuntimeException runtimeEx) {
            return  false;
        }
    }

    //404
    protected ResponseEntity<Object> userNotFoundResponseEntity() {
        return badRequestErrorResponseEntity(USER_NOTFOUND);
    }

    //409
    protected ResponseEntity<Object> duplicateEntryResponseEntity(String message) {
        HashMap<String, String> map = new HashMap<>();
        map.put("error", message);
        return new ResponseEntity<>(map, HttpStatus.CONFLICT);
    }

    //404
    protected ResponseEntity<Object> badRequestErrorResponseEntity(String message) {
        HashMap<String, String> map = new HashMap<>();
        map.put("error", message);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    protected Map<String, String> successResponseEntity() {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "success");
        return map;
    }

    protected ResponseEntity<Object> successResponseEntity(String message) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
