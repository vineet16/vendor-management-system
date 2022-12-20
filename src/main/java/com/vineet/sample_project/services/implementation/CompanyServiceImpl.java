package com.vineet.sample_project.services.implementation;

import com.vineet.sample_project.Exceptions.ResourceNotFoundException;
import com.vineet.sample_project.entities.Company;
import com.vineet.sample_project.payload.CompanyDto;
import com.vineet.sample_project.repositories.CompanyRepository;
import com.vineet.sample_project.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company savedCompany = this.companyRepository.save(this.dtoToCompany(companyDto));
        return this.companyToDto(savedCompany);
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto, Integer companyId) {
        Company company = this.companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company", " id ", companyId ));

        company.setPhone_no(company.getPhone_no());
        company.setEmail(company.getEmail());

        Company updatedCompany = this.companyRepository.save(company);
        return this.companyToDto(updatedCompany);
    }

    @Override
    public CompanyDto getCompanyById(Integer companyId) {
        Company company = this.companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company", " id ", companyId ));
        return this.companyToDto(company);
    }


    @Override
    public List<CompanyDto> getAllCompany() {
        List<Company> companyList = this.companyRepository.findAll();

        List<CompanyDto> companyDtoList = companyList.stream().map(company -> this.companyToDto(company)).collect(Collectors.toList());
        return companyDtoList;
    }

    @Override
    public void deleteCompany(Integer companyId) {
        Company company = this.companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company", " id ", companyId ));
        this.companyRepository.delete(company);
    }

    private Company dtoToCompany(CompanyDto companyDto){
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setCIN_No(companyDto.getCIN_No());
        company.setName(companyDto.getName());
        company.setPhone_no(companyDto.getEmail());
        company.setEmail(companyDto.getEmail());
        company.setGST_no(companyDto.getGST_no());

        return company;
    }

    private CompanyDto companyToDto(Company company){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setCIN_No(companyDto.getCIN_No());
        companyDto.setName(company.getName());
        companyDto.setPhone_no(company.getEmail());
        companyDto.setEmail(company.getEmail());
        companyDto.setGST_no(company.getGST_no());

        return companyDto;
    }
}
