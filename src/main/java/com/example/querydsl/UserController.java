package com.example.querydsl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/dsl")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/select")
    public ResponseEntity<Object> selectUser() {
        return new ResponseEntity<>(userService.findUserAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/insertRand")
    public ResponseEntity<Object> insertRandomUser() {
        userService.insertUser();
        return new ResponseEntity<>(userService.findUserAll(), HttpStatus.OK);
    }
}
