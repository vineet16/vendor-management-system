package com.vineet.sample_project.services;

import com.vineet.sample_project.payload.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CompanyDto companyDto);

    CompanyDto updateCompany(CompanyDto companyDto, Integer companyId);

    CompanyDto getCompanyById(Integer companyId);

    List<CompanyDto> getAllCompany();

    void deleteCompany(Integer companyId);

}
