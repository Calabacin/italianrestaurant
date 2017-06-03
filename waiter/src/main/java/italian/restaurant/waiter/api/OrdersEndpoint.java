package italian.restaurant.waiter.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import italian.restaurant.waiter.event.output.SendOrder;
import italian.restaurant.waiter.ui.websocket.WaiterMessagesWebsocket;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/order")
@Log4j
@RequiredArgsConstructor
public class OrdersEndpoint {

    private final SendOrder order;

    private final WaiterMessagesWebsocket waiterMessagesWebsocket;

    @GetMapping("/{name}")
    public String order(@PathVariable String name) {
        order.send(name);
        waiterMessagesWebsocket.send("Your order of " + name + " has been noted.");
        log.info("Order sent: " + name);
        return "Your " + name + " dish was noted.";
    }
}
