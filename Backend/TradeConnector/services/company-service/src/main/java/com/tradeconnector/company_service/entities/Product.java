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
public class Product extends BaseEntity {

    private String name;
    private String price;
    private String stock;
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

}
