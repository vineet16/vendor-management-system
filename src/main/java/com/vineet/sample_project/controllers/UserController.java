package com.vineet.sample_project.controllers;

import com.vineet.sample_project.payload.UserDTO;
import com.vineet.sample_project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    //Post - user create
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = this.userServices.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //Get - return user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable Integer userId){
        UserDTO user = this.userServices.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Get - return all user
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userList = this.userServices.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //Put - update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("userId") Integer user_Id){
        UserDTO updatedUser = this .userServices.updateUser(userDTO, user_Id);
        return ResponseEntity.ok(updatedUser);
    }
    //Delete - delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        this.userServices.deleteUser(userId);
        return ResponseEntity.ok(Map.of("message", "User Deleted Successfully!", "status", true));
    }
}
