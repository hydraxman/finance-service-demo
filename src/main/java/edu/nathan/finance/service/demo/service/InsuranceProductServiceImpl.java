package edu.nathan.finance.service.demo.service;

import edu.nathan.finance.service.demo.exception.EntityMappingException;
import edu.nathan.finance.service.demo.model.InsuranceProduct;
import edu.nathan.finance.service.demo.model.InsuranceProductInput;
import edu.nathan.finance.service.demo.repository.InsuranceProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
public class InsuranceProductServiceImpl implements InsuranceProductService {

    private final InsuranceProductRepository insuranceProductRepository;

    @Autowired
    public InsuranceProductServiceImpl(InsuranceProductRepository insuranceProductRepository) {
        this.insuranceProductRepository = insuranceProductRepository;
    }

    public Flux<InsuranceProduct> getAllInsuranceProducts() {
        final String errorMessage = "There is an issue getting all of insuranceProducts.";
        Flux<InsuranceProduct> all = this.insuranceProductRepository.findAll();
        return processWithErrorCheck(all, errorMessage);
    }

    public Mono<InsuranceProduct> getInsuranceProductById(Integer id) {
        final String errorMessage = String.format("There is no insuranceProduct with id: '%d'", id);
        return processWithErrorCheck(this.insuranceProductRepository.findById(id), errorMessage);
    }

    public Mono<InsuranceProduct> getInsuranceProductByName(String name) {
        final String errorMessage = String.format("There is no insuranceProduct with name: '%s'", name);
        return processWithErrorCheck(this.insuranceProductRepository.findByProductName(name), errorMessage);
    }

    public Mono<InsuranceProduct> addInsuranceProduct(InsuranceProductInput insuranceProductInput) {
        final String errorMessage = "Unable to add insuranceProduct with input:" + insuranceProductInput;
        return processWithErrorCheck(this.insuranceProductRepository.save(new InsuranceProduct(insuranceProductInput)), errorMessage);
    }

    public Mono<InsuranceProduct> updateInsuranceProduct(@Argument Integer id, @Argument InsuranceProductInput insuranceProductInput) {
        final String errorMessage =
                "Unable to update insuranceProduct with id" + id + "input:" + insuranceProductInput;
        return processWithErrorCheck(this.insuranceProductRepository.findById(Objects.requireNonNull(id)),
                errorMessage)
                .flatMap(insuranceProduct -> {
                    insuranceProduct
                            .setProductName(insuranceProductInput.getProductName())
                            .setTerm(insuranceProductInput.getTerm())
                            .setType(insuranceProductInput.getType())
                            .setPaymentMethod(insuranceProductInput.getPaymentMethod())
                            .setPrice(insuranceProductInput.getPrice())
                            .setDescription(insuranceProductInput.getDescription())
                            .setMainImageUrl(insuranceProductInput.getMainImageUrl());
                    return this.insuranceProductRepository.save(insuranceProduct).log();
                });
    }

    @Override
    public Mono<InsuranceProduct> deleteInsuranceProductById(Integer id) {
        return getInsuranceProductById(id).map(insuranceProduct -> {
            this.insuranceProductRepository.deleteById(id).subscribe();
            return insuranceProduct;
        });
    }

    @Override
    public Mono<InsuranceProduct> deleteInsuranceProductByName(String name) {
        return getInsuranceProductByName(name).map(insuranceProduct -> {
            this.insuranceProductRepository.deleteByProductName(name).subscribe();
            return insuranceProduct;
        });
    }

    private <T> Mono<T> processWithErrorCheck(Mono<T> monoToCheck, String errorMessage) {
        return monoToCheck.switchIfEmpty(Mono.defer(() -> {
            log.error(errorMessage);
            return Mono.error(new EntityMappingException(errorMessage));
        }));
    }

    private <T> Flux<T> processWithErrorCheck(Flux<T> fluxToCheck, String errorMessage) {
        return fluxToCheck.switchIfEmpty(Flux.defer(() -> {
            log.error(errorMessage);
            return Flux.error(new EntityMappingException(errorMessage));
        }));
    }
}
