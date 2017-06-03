package italian.restaurant.cook.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import italian.restaurant.cook.events.channel.Dishes;
import italian.restaurant.cook.events.channel.Orders;

@Configuration
@EnableBinding({ Orders.class, Dishes.class })
public class EventConfiguration {}
