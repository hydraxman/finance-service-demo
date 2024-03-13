package edu.nathan.finance.service.demo.controller;

import edu.nathan.finance.service.demo.model.UserEntity;
import edu.nathan.finance.service.demo.service.UserEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.logging.Level;

@Slf4j
@Controller
public class UserGraphQLController {

    private final UserEntityService userEntityService;

    @Autowired
    public UserGraphQLController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @QueryMapping("listUsers")
    Flux<UserEntity> listUsers() {
        log.info("Get all players using 'getAllInsuranceProducts' query");
        return processWithLog(this.userEntityService.getUsers());
    }

    @QueryMapping("user")
    Mono<UserEntity> user(@Argument Integer id) {
        log.info("Get player by id using 'getInsuranceProductById' query");
        return processWithLog(this.userEntityService.getUser(id));
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
