package italian.restaurant.waiter.ui.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import italian.restaurant.waiter.ui.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class WaiterMessagesWebsocket {

    private final SimpMessagingTemplate simpleMessagingTemplate;

    public void send(String waiterMessage) {
        log.info("Saying: " + waiterMessage);
        Message message = Message.builder()
                                 .content(waiterMessage)
                                 .build();
        simpleMessagingTemplate.convertAndSend("/topic/waitermessages", message);
    }

}
