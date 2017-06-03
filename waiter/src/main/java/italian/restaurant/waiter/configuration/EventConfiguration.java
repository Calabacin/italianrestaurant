package italian.restaurant.waiter.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import italian.restaurant.waiter.event.channel.Dishes;
import italian.restaurant.waiter.event.channel.Menu;
import italian.restaurant.waiter.event.channel.Orders;

@Configuration
@EnableBinding({ Orders.class, Dishes.class, Menu.class })
public class EventConfiguration {}
