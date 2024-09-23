package com.tradeconnector.company_service.entities;

import com.tradeconnector.company_service.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@SuperBuilder
@Setter
@Entity
public class Company extends BaseEntity {

    @Column(length = 50)
    private String name;
    private String address;
    @Column(length = 14)
    private String mobile;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "company")
    private List<Product> products;
    @OneToMany(mappedBy = "company")
    private List<JobRequest> jobRequests;
}
