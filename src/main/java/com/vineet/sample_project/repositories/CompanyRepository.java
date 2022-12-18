package com.vineet.sample_project.repositories;

import com.vineet.sample_project.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
