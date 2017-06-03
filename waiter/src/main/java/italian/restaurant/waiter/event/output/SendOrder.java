package italian.restaurant.waiter.event.output;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import italian.restaurant.waiter.event.channel.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendOrder {

    @Qualifier("orders")
    private final Orders orders;

    public void send(String dishName) {
        Order order = createOrder(dishName);
        Message<Order> message = createMessage(order);
        orders.orders()
              .send(message);
    }

    private Order createOrder(String dishName) {
        Order order = Order.builder()
                           .name(dishName)
                           .build();
        return order;
    }

    private Message<Order> createMessage(Order order) {
        Message<Order> message = MessageBuilder.withPayload(order)
                                               .build();
        return message;
    }

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Order {

    private String name;

}
