package com.vineet.sample_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = true, length = 10)
    private int phone_no;

    @Column(nullable = true, length = 100)
    private String email;

    public User(int id, String name, Company company, String password, int phone_no, String email) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.password = password;
        this.phone_no = phone_no;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", password='" + password + '\'' +
                ", phone_no=" + phone_no +
                ", email='" + email + '\'' +
                '}';
    }
}
