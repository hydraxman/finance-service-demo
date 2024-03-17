package edu.nathan.finance.service.demo.repository;

import edu.nathan.finance.service.demo.model.InsuranceProduct;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface InsuranceProductRepository extends ReactiveCrudRepository<InsuranceProduct, Integer> {
    Mono<InsuranceProduct> findByProductName(String productName);

    Mono<InsuranceProduct> deleteByProductName(String productName);

}