package italian.restaurant.menu.event.output;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import italian.restaurant.menu.event.channel.Menu;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class SendMenu {

    private final Menu menu;

    public void send(String waiterName, italian.restaurant.menu.domain.Menu theMenu) {
        log.info("Sending menu to: " + waiterName);
        Message<italian.restaurant.menu.domain.Menu> message = MessageBuilder.withPayload(theMenu)
                                                                             .build();
        menu.menu()
            .send(message);
    }
}