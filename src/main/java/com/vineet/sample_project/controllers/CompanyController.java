package com.vineet.sample_project.controllers;

import com.vineet.sample_project.payload.CompanyDto;
import com.vineet.sample_project.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    //Get-return user
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto> getSingleCompany(@PathVariable Integer companyId){
        CompanyDto companyDto = this.companyService.getCompanyById(companyId);
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        List<CompanyDto> companyList = this.companyService.getAllCompany();
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }
    //Post
    @PostMapping("")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto){
        CompanyDto createdCompany = this.companyService.createCompany(companyDto);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto, @PathVariable("userId") Integer companyId){
        CompanyDto updatedCompany = this .companyService.updateCompany(companyDto, companyId);
        return ResponseEntity.ok(updatedCompany);
    }

    //Delete
    @DeleteMapping("/{companyId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer companyId){
        this.companyService.deleteCompany(companyId);
        return ResponseEntity.ok(Map.of("message", "Company Deleted Successfully!", "status", true));
    }

}
