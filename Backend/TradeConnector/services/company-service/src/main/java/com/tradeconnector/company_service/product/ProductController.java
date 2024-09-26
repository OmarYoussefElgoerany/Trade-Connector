package com.tradeconnector.company_service.product;

import com.tradeconnector.company_service.common.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer> create(
            @RequestBody @Valid ProductRequest request
    ) {
        return ResponseEntity.ok(this.service.Create(request));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> updateCustomer(
            @RequestBody @Valid ProductRequest request
    ) {

        return ResponseEntity.ok(this.service.update(request));
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<PageResponse<ProductResponse>> findAll(@PathVariable("page")
                                                                 int page, @PathVariable("size")
                                                                 int size) {
        return ResponseEntity.ok(this.service.getProductsWithCompanyName(page, size));
    }

    @GetMapping("/{prod-id}")
    public ResponseEntity<ProductResponse> GetById(
            @PathVariable("prod-id") Integer prodId
    ) {
        return ResponseEntity.ok(this.service.findById(prodId));
    }

    @DeleteMapping("/{prod-id}")
    public ResponseEntity<String> delete(
            @PathVariable("prod-id") Integer prodId
    ) {
        this.service.delete(prodId);
        return ResponseEntity.ok("Deleted");
    }

}
