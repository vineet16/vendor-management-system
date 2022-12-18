package com.vineet.sample_project.repositories;

import com.vineet.sample_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
