package com.tradeconnector.company_service.entities;

import com.tradeconnector.company_service.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Entity
@SuperBuilder
public class JobRequest extends BaseEntity {
    private String productName;
    private int quantity;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
