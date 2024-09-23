package com.tradeconnector.company_service.company;

import com.tradeconnector.company_service.common.PageResponse;
import com.tradeconnector.company_service.entities.Company;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepo;
    private final CompanyMapper companyMapper;

    public Integer Create(CompanyRequest request) {
        Company company = companyMapper.toCompany(request);
        return companyRepo.save(company).getId();
    }

    public CompanyResponse findById(Integer compId) {
        return companyRepo.findById(compId)
                .map(companyMapper::toCompResponse)
                .orElseThrow(() -> new EntityNotFoundException("No company found with ID:: " + compId));
    }

    public PageResponse<CompanyResponse> findAllCompanies(int page, int size) {
        // Create a pageable object with valid page and size, sorting by "createdDate"
        Pageable pageable = PageRequest.of(page-1, size);

        // Retrieve paginated result
        Page<Company> companies = companyRepo.findAll(pageable);

        // Log for debugging
        System.out.println("Total companies retrieved: " + companies.getTotalElements());
        System.out.println("Page content size: " + companies.getContent().size());

        // Map the companies to the CompanyResponse DTO
        List<CompanyResponse> companyResponses = companies.getContent().stream()
                .map(companyMapper::toCompResponse)
                .toList();

        // Return the paginated response
        return new PageResponse<>(
                companyResponses,
                companies.getNumber(),
                companies.getSize(),
                companies.getTotalElements(),
                companies.getTotalPages(),
                companies.isFirst(),
                companies.isLast()
        );
    }

    public boolean delete(Integer compId) {
        Company comp = companyRepo.findById(compId)
                .orElseThrow(() -> new EntityNotFoundException("No Comp found with ID:: " + compId));
        ;

        if (comp == null) {
            return false;
        }

        companyRepo.delete(comp);
        return true;
    }
    public CompanyResponse update(CompanyRequest companyRequest) {
        Company comp = companyRepo.findById(companyRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("No Comp found with ID:: " + companyRequest.id()));
        ;
        Company company = companyMapper.toCompany(companyRequest);
        if (comp == null) {
            return new CompanyResponse();
        }

        companyRepo.save(company);

        return companyMapper.toCompResponse(company);
    }
}
