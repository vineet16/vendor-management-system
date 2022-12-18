package com.vineet.sample_project.services.implementation;

import com.vineet.sample_project.Exceptions.ResourceNotFoundException;
import com.vineet.sample_project.entities.User;
import com.vineet.sample_project.payload.UserDTO;
import com.vineet.sample_project.repositories.UserRepository;
import com.vineet.sample_project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User savedUser = this.userRepo.save(this.dtoToUser(userDto));
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId ));

        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepo.save(user);

        return this.userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId ));
        return this.userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = this.userRepo.findAll();

        List<UserDTO> userDtoList = userList.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId ));
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail((userDTO.getEmail()));
        user.setPhone_no(userDTO.getPhone_no());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    private UserDTO userToDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail((user.getEmail()));
        userDTO.setPhone_no(user.getPhone_no());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
