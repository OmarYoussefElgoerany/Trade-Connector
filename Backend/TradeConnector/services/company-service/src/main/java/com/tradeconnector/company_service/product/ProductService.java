package com.tradeconnector.company_service.product;

import com.tradeconnector.company_service.common.PageResponse;
import com.tradeconnector.company_service.entities.Product;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;
    private final ProductMapper productMapper;

    public Integer Create(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        return productRepo.save(product).getId();
    }

    public ProductResponse findById(Integer prodId) {
        return productRepo.findById(prodId)
                .map(productMapper::toProdResponse)
                .orElseThrow(() -> new EntityNotFoundException("No Prodcut found with ID:: " + prodId));
    }
    public PageResponse<ProductResponse> getProductsWithCompanyName(int page, int size) {
        if(page == 0){
            page = 1;
        }else if(size == 0){
            size = 1;
        }
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductResponse> productPage = productRepo.findAllWithCompanyName(pageable);

        // Create and return PageResponse<ProductResponse>
        return new PageResponse<>(
                productPage.getContent(),
                productPage.getNumber(),
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isFirst(),
                productPage.isLast()
        );
    }

    public boolean delete(Integer prodId) {
        Product comp = productRepo.findById(prodId)
                .orElseThrow(() -> new EntityNotFoundException("No Product found with ID:: " + prodId));
        ;

        if (comp == null) {
            return false;
        }

        productRepo.delete(comp);
        return true;
    }

    public ProductResponse update(ProductRequest productReq) {
        Product comp = productRepo.findById(productReq.id())
                .orElseThrow(() -> new EntityNotFoundException("No Product found with ID:: " + productReq.id()));
        ;
        Product product = productMapper.toProduct(productReq);
        if (comp == null) {
            return new ProductResponse();
        }

        productRepo.save(product);

        return productMapper.toProdResponse(product);
    }
}
