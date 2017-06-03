package italian.restaurant.menu.event.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Menu {

    String REQUEST_MENU = "requestmenu";

    @Input(REQUEST_MENU)
    SubscribableChannel requestMenu();

    @Output
    MessageChannel menu();

}
