package italian.restaurant.cook.events.input;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import italian.restaurant.cook.domain.Order;
import italian.restaurant.cook.events.channel.Orders;
import italian.restaurant.cook.logic.CookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReceiveOrder {

    private final CookingService cookingService;

    @StreamListener(Orders.ORDERS)
    public void receiveOrder(Order order) {
        log.info("Order Received: " + order);
        cookingService.cook(order);
    }

}
