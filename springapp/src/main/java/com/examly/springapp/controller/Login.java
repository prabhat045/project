package main.java.com.examly.springapp.controller;

import main.java.com.examly.springapp.model.LoginModel;
import main.java.com.examly.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class Login {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> loginUser(@RequestBody LoginModel user) {
        if (userService.doesUserExists(user))
            return new ResponseEntity<>("true", HttpStatus.OK);

        return new ResponseEntity<>("false", HttpStatus.OK);
    }


}