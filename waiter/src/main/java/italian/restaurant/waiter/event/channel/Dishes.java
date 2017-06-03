package italian.restaurant.waiter.event.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Dishes {

    String DISHES = "dishes";

    @Input(DISHES)
    SubscribableChannel dishes();

}