package com.vineet.sample_project.services;

import com.vineet.sample_project.payload.UserDTO;

import java.util.List;

public interface UserServices {

     UserDTO createUser(UserDTO user);

     UserDTO updateUser(UserDTO user, Integer userId);

     UserDTO getUserById(Integer userId);

     List<UserDTO> getAllUsers();

     void deleteUser(Integer userId);
}
