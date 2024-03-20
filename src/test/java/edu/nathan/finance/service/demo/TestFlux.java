package edu.nathan.finance.service.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestFlux {
    @Test
    public void testFlux() {
        printThread("Start");
        Flux<String> a = Flux.just("A");
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .doOnCancel(() -> printThread("Cancelled"))
                .doOnComplete(() -> printThread("Complete"))
                .doOnNext(i -> printThread("Next: " + i))
                .doOnEach(signal -> printThread("Each: " + signal))
                .doOnSubscribe(subscription -> printThread("Subscribe: " + subscription))
                .map(i -> i * 2)
                .flatMap(i -> Flux.just(i, i + 1, i + 2))
                .filter(i -> i > 10)
                .doOnComplete(() -> printThread("\tComplete1"))
                .subscribe(r -> printThread("\tResult: " + r));
    }

    public void printThread(String message) {
        System.out.println(message + " Thread: " + Thread.currentThread().getName());
    }

    @Test
    public void testMono() {
        Mono.just(1)
                .doOnSuccess(i -> printThread("Success: " + i))
                .map(i -> i * 2)
                .subscribe(s -> printThread("Result: " + s));
    }

    @Test
    public void testMono2Flux() throws InterruptedException {
        Mono.just(10)
                .flatMapMany(i -> Flux.range(1, i).map(j -> 1))
                .delayElements(java.time.Duration.ofMillis(100))
                .subscribe(r -> printThread("Result: " + r));

        Thread.sleep(2 * 1000);
    }
}
