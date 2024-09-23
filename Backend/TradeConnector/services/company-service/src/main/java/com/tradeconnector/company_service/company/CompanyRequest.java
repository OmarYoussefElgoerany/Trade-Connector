package com.tradeconnector.company_service.company;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record CompanyRequest(
        Integer id,
        @NotNull
        @NotEmpty
        String name,
        String address,
        @NotNull
        @NotEmpty
        String email, String mobile
        ) {
}
