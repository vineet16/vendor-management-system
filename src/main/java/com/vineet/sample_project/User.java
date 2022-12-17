package com.vineet.sample_project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private int company_id;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = true, length = 10)
    private int phone_no;

    @Column(nullable = true, length = 100)
    private String email;
}
