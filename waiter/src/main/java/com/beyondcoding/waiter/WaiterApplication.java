package com.beyondcoding.waiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@SpringBootApplication
@EnableBinding(WaiterActivity.class)
@RestController
@RequiredArgsConstructor
@Log4j
public class WaiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaiterApplication.class, args);
    }

    private final MessageChannel orders;

    @GetMapping("/order/{name}")
    public String order(@PathVariable String name) {
        Dish dish = Dish.builder()
                        .name(name)
                        .build();
        Message<Dish> message = MessageBuilder.withPayload(dish)
                                              .build();
        orders.send(message);
        return "Your " + name + " dish was noted.";
    }

    @StreamListener(WaiterActivity.PREPARED_DISHES)
    public void receivePreparedDish(Dish dish) {
        log.info("Dish is prepared. Here you are, your freshly cooked: " + dish.getName());
    }

}

interface WaiterActivity {

    String PREPARED_DISHES = "prepareddishes";

    @Output
    MessageChannel orders();

    @Input(PREPARED_DISHES)
    SubscribableChannel preparedDishes();

}
