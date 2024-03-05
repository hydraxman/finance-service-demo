package edu.nathan.finance.service.demo.service;

import edu.nathan.finance.service.demo.model.InsuranceProduct;
import edu.nathan.finance.service.demo.model.InsuranceProductInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InsuranceProductService {
    Mono<InsuranceProduct> getInsuranceProductById(Integer id);

    Mono<InsuranceProduct> getInsuranceProductByName(String name);

    Flux<InsuranceProduct> getAllInsuranceProducts();

    Mono<InsuranceProduct> addInsuranceProduct(InsuranceProductInput insuranceProductInput);

    Mono<InsuranceProduct> updateInsuranceProduct(Integer id, InsuranceProductInput insuranceProductInput);

    Mono<InsuranceProduct> deleteInsuranceProductById(Integer id);

    Mono<InsuranceProduct> deleteInsuranceProductByName(String name);

}
