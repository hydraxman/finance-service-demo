package edu.nathan.finance.service.demo.controller;
import org.reactivestreams.Publisher;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class SubscriptionResolver {

    @SubscriptionMapping("count")
    public Publisher<Integer> count(@Argument Integer from, @Argument Integer to) {
        return Flux.range(from, to - from + 1);
    }
}
