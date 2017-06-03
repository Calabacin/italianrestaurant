package italian.restaurant.waiter.event.output;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import italian.restaurant.waiter.event.channel.Menu;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class RequestMenu {

    private final Menu menu;

    public void request(String waiterName) {
        Message<String> message = MessageBuilder.withPayload(waiterName)
                                                .build();
        log.info("Requesting menu");
        menu.requestMenu()
            .send(message);
    }

}
