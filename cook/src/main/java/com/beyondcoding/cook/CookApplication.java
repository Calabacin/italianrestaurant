package com.beyondcoding.cook;

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

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@SpringBootApplication
@EnableBinding(KitchenActivity.class)
@Log4j
@RequiredArgsConstructor
public class CookApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookApplication.class, args);
    }

    private final MessageChannel preparedDishes;

    @StreamListener(KitchenActivity.ORDERS)
    public void receiveOrder(Dish dish) {
        log.info("Order Received: " + dish);
        cook(dish);
        notifyWaiterFoodIsReady(dish);
    }

    private void cook(Dish dish) {
        try {
            Thread.sleep(2 * 1000);
            log.info("Food is ready");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void notifyWaiterFoodIsReady(Dish dish) {
        Message<Dish> message = MessageBuilder.withPayload(dish)
                                              .build();
        preparedDishes.send(message);
    }

}

interface KitchenActivity {

    String ORDERS = "orders";

    @Input(ORDERS)
    SubscribableChannel orders();

    @Output
    MessageChannel preparedDishes();

}