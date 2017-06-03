package italian.restaurant.waiter.event.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Menu {

    String MENU = "menu";

    @Input(MENU)
    SubscribableChannel menu();

    @Output("requestmenu")
    MessageChannel requestMenu();

}
