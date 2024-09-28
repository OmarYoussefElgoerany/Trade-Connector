package com.tradeconnector.company_service.jobRequest;

import com.tradeconnector.company_service.entities.JobRequest;
import com.tradeconnector.company_service.product.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRequestRepository extends JpaRepository<JobRequest, Integer> {
    @Query("SELECT new com.tradeconnector.company_service.jobRequest.JobRequestResponse(j.id, j.productName, j.quantity, j.description, j.status, c.id, j.createdDate, j.lastModifiedDate, j.createdBy, j.lastModifiedBy) " +
            "FROM JobRequest j JOIN j.company c")
    Page<JobRequestResponse> findAllWithCompanyName(Pageable pageable);
}
