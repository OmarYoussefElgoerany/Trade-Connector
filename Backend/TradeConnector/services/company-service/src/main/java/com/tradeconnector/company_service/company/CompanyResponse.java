package com.tradeconnector.company_service.company;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponse {
    private Integer id;
    private String name;
    private String address;
    private String mobile;
    private String email;
}
