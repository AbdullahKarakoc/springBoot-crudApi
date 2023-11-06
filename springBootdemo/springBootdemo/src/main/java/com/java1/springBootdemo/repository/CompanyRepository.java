package com.java1.springBootdemo.repository;

import com.java1.springBootdemo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company findByName(String name);
}
