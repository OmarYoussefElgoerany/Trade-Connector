package com.tradeconnector.company_service.product;


import com.tradeconnector.company_service.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.tradeconnector.company_service.product.ProductResponse(p.id, p.name, p.price, p.stock, p.description, c.name) " +
            "FROM Product p JOIN p.company c")
    Page<ProductResponse> findAllWithCompanyName(Pageable pageable);
}
