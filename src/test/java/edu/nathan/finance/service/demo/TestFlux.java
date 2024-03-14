package edu.nathan.finance.service.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestFlux {
    @Test
    public void testFlux() {
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6,7,8,9,10);
        flux.map(i -> i * 2)
                .flatMap(i -> Flux.just(i, i + 1, i + 2))
                .filter(i -> i > 10)
                .subscribe(System.out::println);
        Mono<Integer> mono = Mono.just(1);
        mono.doOnSuccess(i -> System.out.println("Success: " + i))
                .subscribe(s -> System.out.println("Mono: " + s));
    }
}
