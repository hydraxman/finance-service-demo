package edu.nathan.finance.service.demo.controller;

import edu.nathan.finance.service.demo.model.InsuranceProduct;
import edu.nathan.finance.service.demo.model.InsuranceProductInput;
import edu.nathan.finance.service.demo.service.InsuranceProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.logging.Level;

@Slf4j
@Controller
public class InsuranceProductGraphQLController {

    private final InsuranceProductService insuranceProductService;

    @Autowired
    public InsuranceProductGraphQLController(InsuranceProductService insuranceProductService) {
        this.insuranceProductService = insuranceProductService;
    }

    @QueryMapping("listInsuranceProducts")
    Flux<InsuranceProduct> listInsuranceProducts() {
        log.info("Get all players using 'getAllInsuranceProducts' query");
        return processWithLog(this.insuranceProductService.getAllInsuranceProducts());
    }

    @QueryMapping("insuranceProduct")
    Mono<InsuranceProduct> insuranceProduct(@Argument Integer id) {
        log.info("Get player by id using 'getInsuranceProductById' query");
        return processWithLog(this.insuranceProductService.getInsuranceProductById(id));
    }

    @QueryMapping("getInsuranceProductByName")
    Mono<InsuranceProduct> getInsuranceProductByName(@Argument String name) {
        log.info("Get player by name using 'getInsuranceProductByName' query");
        return processWithLog(this.insuranceProductService.getInsuranceProductByName(name));
    }


    @MutationMapping("addInsuranceProduct")
    Mono<InsuranceProduct> addInsuranceProduct(@Argument InsuranceProductInput insuranceProductInput) {
        log.info("Add player using 'addInsuranceProduct' mutation");
        return processWithLog(this.insuranceProductService.addInsuranceProduct(insuranceProductInput));
    }

    @MutationMapping("updateInsuranceProduct")
    Mono<InsuranceProduct> updateInsuranceProduct(@Argument Integer id, @Argument InsuranceProductInput insuranceProductInput) {
        log.info("Updating player using 'updateInsuranceProduct' mutation");
        return processWithLog(this.insuranceProductService.updateInsuranceProduct(id, insuranceProductInput));
    }

    @MutationMapping("deleteInsuranceProductById")
    Mono<InsuranceProduct> deleteInsuranceProductById(@Argument Integer id) {
        log.info("Delete player using 'deleteInsuranceProductById' mutation");
        return processWithLog(this.insuranceProductService.deleteInsuranceProductById(id));
    }

    @MutationMapping("deleteInsuranceProductByName")
    Mono<InsuranceProduct> deleteInsuranceProductById(@Argument String name) {
        log.info("Delete player using 'deleteInsuranceProductByName' mutation");
        return processWithLog(this.insuranceProductService.deleteInsuranceProductByName(name));
    }

    private <T> Mono<T> processWithLog(Mono<T> monoToLog) {
        return monoToLog
                .log("InsuranceProductGraphQLController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
    }

    private <T> Flux<T> processWithLog(Flux<T> fluxToLog) {
        return fluxToLog
                .log("InsuranceProductGraphQLController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
    }
}
