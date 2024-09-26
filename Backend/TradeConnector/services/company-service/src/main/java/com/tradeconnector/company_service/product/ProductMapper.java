package com.tradeconnector.company_service.product;

import com.tradeconnector.company_service.entities.Company;
import com.tradeconnector.company_service.entities.Product;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductMapper {
    private final EntityManager entityManager;

    public Product toProduct(ProductRequest productRequest) {
        Company company = entityManager.getReference(Company.class, productRequest.company_id());

        return Product.builder().id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .stock(productRequest.stock())
                .company(company)
                .build();
    }

    public ProductResponse toProdResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .description(product.getDescription())
                .name(product.getName())
                .stock(product.getStock())
                .companyName(product.getCompany().getName())
                .build();
    }
}
