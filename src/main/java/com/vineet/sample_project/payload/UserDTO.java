package com.vineet.sample_project.payload;

import com.vineet.sample_project.entities.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    private String name;
    private String phone_no;
    private String email;
    private String password;
}
