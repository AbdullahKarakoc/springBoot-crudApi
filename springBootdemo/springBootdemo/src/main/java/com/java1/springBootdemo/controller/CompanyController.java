package com.java1.springBootdemo.controller;

import com.java1.springBootdemo.entity.Company;
import com.java1.springBootdemo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company){
        return service.saveCompany(company);
    }
    @PostMapping("/addCompanys")
    public List<Company> addCompanys(@RequestBody List<Company> companys){
        return service.saveCompanys(companys);
    }

    @GetMapping("/companys")
    public List<Company> findAllCompanys(){
        return service.getCompanys();
    }
    @GetMapping("/CompanyById/{id}")
    public Company findCompanyById(@PathVariable int id) {
        return service.getCompanyById(id);
    }
    @GetMapping("/company/{name}")
    public Company findCompanyByName(@PathVariable String  name) {
        return service.getCompanyByName(name);
    }

    @PutMapping("/updateCompany")
    public Company updateCompany(@RequestBody Company company){
        return service.updateCompany(company);
    }
    @DeleteMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable int id){return service.deleteCompany(id);
    }

}
