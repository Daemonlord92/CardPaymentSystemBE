package com.binarymjm.cardpaymentsystem.controller;

import com.binarymjm.cardpaymentsystem.dto.PostNewUser;
import com.binarymjm.cardpaymentsystem.dto.PostUpdateUser;
import com.binarymjm.cardpaymentsystem.dto.UserInfo;
import com.binarymjm.cardpaymentsystem.service.UserService;
import com.binarymjm.cardpaymentsystem.shared.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("apiv1/user")
public class UserController {
    protected final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<MessageResponse> postNewUser(@RequestBody PostNewUser postNewUser) {
        return new ResponseEntity<>(userService.createUser(postNewUser), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<MessageResponse> postUpdateUser(@RequestBody PostUpdateUser postUpdateUser) {
        return new ResponseEntity<>(userService.updateUser(postUpdateUser), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.ACCEPTED);
    }
}
