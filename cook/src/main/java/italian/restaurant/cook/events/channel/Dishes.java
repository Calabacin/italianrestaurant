package italian.restaurant.cook.events.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Dishes {

    @Output
    MessageChannel dishes();

}