package com.tradeconnector.company_service.company;

import com.tradeconnector.company_service.entities.Company;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
