package com.tradeconnector.company_service.company;

import com.tradeconnector.company_service.common.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;

    @PostMapping
    public ResponseEntity<Integer> createCompany(
            @RequestBody @Valid CompanyRequest request
    ) {
        return ResponseEntity.ok(this.service.Create(request));
    }

    @PutMapping
    public ResponseEntity<CompanyResponse> updateCustomer(
            @RequestBody @Valid CompanyRequest request
    ) {

        return ResponseEntity.ok(this.service.update(request));
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<PageResponse<CompanyResponse>> findAll(@PathVariable("page")
                                                                 int page, @PathVariable("size")
                                                                 int size) {
        return ResponseEntity.ok(this.service.findAllCompanies(page, size));
    }

    @GetMapping("/{company-id}")
    public ResponseEntity<CompanyResponse> GetById(
            @PathVariable("company-id") Integer companyId
    ) {
        return ResponseEntity.ok(this.service.findById(companyId));
    }

    @DeleteMapping("/{company-id}")
    public ResponseEntity<String> delete(
            @PathVariable("company-id") Integer companyId
    ) {
        this.service.delete(companyId);
        return ResponseEntity.ok("Deleted");
    }

}
