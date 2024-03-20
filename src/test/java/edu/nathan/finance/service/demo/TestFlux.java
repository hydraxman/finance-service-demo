package edu.nathan.finance.service.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

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

    @Test
    public void testFlux2() throws InterruptedException {
        Flux.range(1, 100)
                .delayElements(java.time.Duration.ofMillis(1000))
                .buffer(3)
                .log()
                .subscribe();

        Thread.sleep(30 * 1000);
    }

    @Test
    public void testFluxCreate() throws InterruptedException {
        Flux.create(sink -> {
                    for (int i = 0; i < 10; i++) {
                        new Thread(new DataRun(sink, i)).start();
                    }
                }).log()
                .subscribe();

        Thread.sleep(30 * 1000);
    }

    static class DataRun implements Runnable {
        private final FluxSink<Object> sink;
        private final int index;

        public DataRun(FluxSink<Object> sink, int i) {
            this.sink = sink;
            this.index = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index == 9) {
                sink.complete();
            } else {
                sink.next(index);
            }
        }
    }

    @Test
    public void testFluxThreading() throws InterruptedException {
        Flux.range(1, 10)
                .publishOn(Schedulers.single())
                .map(i -> i * -1)
                .log()
                .delayElements(Duration.ofMillis(1000))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe();

        Thread.sleep(20 * 1000);
    }
}
