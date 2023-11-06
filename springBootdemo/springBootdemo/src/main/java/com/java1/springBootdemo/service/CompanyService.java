package com.java1.springBootdemo.service;

import com.java1.springBootdemo.entity.Company;
import com.java1.springBootdemo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {this.repository = repository;}

    public Company saveCompany(Company company){
        return repository.save(company);
    }
    public List<Company> saveCompanys(List<Company> companys){
        return repository.saveAll(companys);
    }

    public List<Company> getCompanys(){
        return repository.findAll();
    }
    public Company getCompanyById(int id){
        return repository.findById(id).orElse(null);
    }
    public Company getCompanyByName(String name){
        return repository.findByName(name);
    }

    public String deleteCompany(int id){
        return "!!! Company information is Deleted !!! "+id;
    }

    public Company updateCompany(Company company){
        Company existingEmployee=repository.findById(company.getId()).orElse(null);
        assert existingEmployee != null;
        existingEmployee.setName(company.getName());
        existingEmployee.setCompany_id(company.getCompany_id());
        return repository.save(existingEmployee);
    }


}
