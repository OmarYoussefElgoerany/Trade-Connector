package com.tradeconnector.company_service.jobRequest;

import com.tradeconnector.company_service.common.BaseEntity;
import com.tradeconnector.company_service.entities.Company;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record JobRequestRequest(

        Integer id,
        @NotNull
        @NotEmpty
        String productName,
        @NotNull
        int quantity,
        String description,
        String status,
        @NotNull
        Integer company_id) {
}
