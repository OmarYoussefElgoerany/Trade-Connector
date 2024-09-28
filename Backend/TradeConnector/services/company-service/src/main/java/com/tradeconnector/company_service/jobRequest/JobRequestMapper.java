package com.tradeconnector.company_service.jobRequest;

import com.tradeconnector.company_service.entities.Company;
import com.tradeconnector.company_service.entities.JobRequest;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobRequestMapper {

private final EntityManager entityManager;

    public JobRequest toJobRequest(JobRequestRequest jobRequest) {
        Company company = entityManager.getReference(Company.class, jobRequest.company_id());

        return JobRequest.builder().id(jobRequest.id())
                .productName(jobRequest.productName())
                .quantity(jobRequest.quantity())
                .description(jobRequest.description())
                .status(jobRequest.status())
                .company(company)
                .build();
    }

    public JobRequestResponse toCompResponse(JobRequest jobRequest) {
        return JobRequestResponse.builder()
                .id(jobRequest.getId())
                .productName(jobRequest.getProductName())
                .quantity(jobRequest.getQuantity())
                .description(jobRequest.getDescription())
                .status(jobRequest.getStatus())
                .company_id(jobRequest.getCompany().getId())
                .createdBy(jobRequest.getCreatedBy())
                .createdDate(jobRequest.getCreatedDate())
                .lastModifiedBy(jobRequest.getLastModifiedBy())
                .lastModifiedDate(jobRequest.getLastModifiedDate())
                .build();
    }
}
