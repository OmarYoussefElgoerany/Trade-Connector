package com.tradeconnector.company_service.company;

import com.tradeconnector.company_service.entities.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper {
    public Company toCompany(CompanyRequest companyRequest) {
        return Company.builder().id(companyRequest.id())
                .name(companyRequest.name())
                .address(companyRequest.address())
                .email(companyRequest.email())
                .mobile(companyRequest.mobile())
                .build();
    }

    public CompanyResponse toCompResponse(Company company) {
        System.out.println("Total companies in the database: wee are in mapping");

        return CompanyResponse.builder()
                .id(company.getId())
                .address(company.getAddress())
                .email(company.getEmail())
                .name(company.getName())
                .mobile(company.getMobile())
                .build();
    }
}
