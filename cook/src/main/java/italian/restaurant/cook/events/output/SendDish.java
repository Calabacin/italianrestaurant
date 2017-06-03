package italian.restaurant.cook.events.output;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import italian.restaurant.cook.domain.Dish;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendDish {

    private final MessageChannel dishes;

    public void send(Dish dish) {
        Message<Dish> message = MessageBuilder.withPayload(dish)
                                              .build();
        dishes.send(message);
    }

}
