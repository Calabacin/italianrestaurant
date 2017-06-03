package italian.restaurant.menu.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import italian.restaurant.menu.event.channel.Menu;

@EnableBinding(Menu.class)
@Configuration
public class EventConfiguration {}
