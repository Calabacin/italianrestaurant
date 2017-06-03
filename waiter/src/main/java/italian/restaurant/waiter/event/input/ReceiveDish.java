package italian.restaurant.waiter.event.input;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import italian.restaurant.waiter.event.channel.Dishes;
import italian.restaurant.waiter.ui.dto.Dish;
import italian.restaurant.waiter.ui.websocket.WaiterMessagesWebsocket;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReceiveDish {

    private final WaiterMessagesWebsocket waiterMessagesWebsocket;

    @StreamListener(Dishes.DISHES)
    public void receiveDish(Dish dish) {
        String message = "Dish is prepared. Here you are, your freshly cooked: " + dish.getName();
        log.info(message);
        waiterMessagesWebsocket.send(message);
    }
}
