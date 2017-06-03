package italian.restaurant.waiter.event.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Orders {

    @Output
    MessageChannel orders();

}
