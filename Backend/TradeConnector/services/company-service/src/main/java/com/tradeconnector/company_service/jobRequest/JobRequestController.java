package com.tradeconnector.company_service.jobRequest;

import com.tradeconnector.company_service.common.PageResponse;
import com.tradeconnector.company_service.entities.JobRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobRequest")
@RequiredArgsConstructor
public class JobRequestController {
    private final JobRequestService service;

    @PostMapping
    public ResponseEntity<Integer> createCompany(
            @RequestBody @Valid JobRequestRequest request
    ) {
        return ResponseEntity.ok(this.service.Create(request));
    }

    @PutMapping
    public ResponseEntity<JobRequestResponse> updateCustomer(
            @RequestBody @Valid JobRequestRequest request
    ) {

        return ResponseEntity.ok(this.service.update(request));
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<PageResponse<JobRequestResponse>> findAll(@PathVariable("page")
                                                                 int page, @PathVariable("size")
                                                                 int size) {
        return ResponseEntity.ok(this.service.getAllWithCompanyName(page, size));
    }

    @GetMapping("/{company-id}")
    public ResponseEntity<JobRequestResponse> GetById(
            @PathVariable("company-id") Integer jobReqId
    ) {
        return ResponseEntity.ok(this.service.findById(jobReqId));
    }

    @DeleteMapping("/{company-id}")
    public ResponseEntity<String> delete(
            @PathVariable("company-id") Integer jobReqId
    ) {
        this.service.delete(jobReqId);
        return ResponseEntity.ok("Deleted");
    }

}
