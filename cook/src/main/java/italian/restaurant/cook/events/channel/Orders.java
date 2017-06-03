package italian.restaurant.cook.events.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Orders {

    String ORDERS = "orders";

    @Input(ORDERS)
    SubscribableChannel orders();
}
