package com.tradeconnector.company_service.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private String price;
    private String stock;
    private String description;
    private String companyName;
}
