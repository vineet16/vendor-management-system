package com.vineet.sample_project.repositories;

import com.vineet.sample_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
