package edu.nathan.finance.service.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class TestFlowAPI {
    public static final String GREEN_START = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    @Test
    public void testFlowAPI() throws InterruptedException {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();


        Flow.Subscriber<Integer> integerSubscriber1 = getIntegerSubscriber(GREEN_START + "\tSubscriber 1" + RESET);
        Flow.Subscriber<Integer> integerSubscriber2 = getIntegerSubscriber("Subscriber 2");


        Flow.Processor<Integer, Integer> processor1 = createProcessor(GREEN_START + "\tProcessor 1" + RESET, 2);
        Flow.Processor<Integer, Integer> processor2 = createProcessor("Processor 2", 5);

        publisher.subscribe(processor1);
        processor1.subscribe(integerSubscriber1);

        publisher.subscribe(processor2);
        processor2.subscribe(integerSubscriber2);

        for (int i = 0; i < 10; i++) {
            publisher.submit(i);
        }

        Thread.sleep(5 * 1000);

        publisher.close();
    }

    private Flow.Processor<Integer, Integer> createProcessor(String name, Integer multiplier) {
        return new MyProcessor(name, multiplier);
    }

    static class MyProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<Integer, Integer> {
        private Flow.Subscription subscription;
        private final String name;
        private final Function<Integer, Integer> function;

        public MyProcessor(String name, Integer multiplier) {
            this.name = name;
            this.function = i -> i * multiplier;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            System.out.println(name + " Subscribed," + " Thread: " + Thread.currentThread().getName());
            subscription.request(1);
        }

        @Override
        public void onNext(Integer item) {
            System.out.println(name + " Got in onNext: " + item + " Thread: " + Thread.currentThread().getName());
            submit(function.apply(item));
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println(name + " Done, Thread: " + Thread.currentThread().getName());
        }
    }

    private static Flow.Subscriber<Integer> getIntegerSubscriber(String name) {
        final String nameFinal = name;
        return new Flow.Subscriber<>() {

            private Flow.Subscription subcription;
            private String name;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subcription = subscription;
                this.name = nameFinal;
                System.out.println(name + " Subscribed, Thread: " + Thread.currentThread().getName());
                subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                subcription.request(1);
                System.out.println(name + " Got in onNext: " + item + " Thread: " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println(name + " Done, " + " Thread: " + Thread.currentThread().getName());
            }
        };
    }
}
