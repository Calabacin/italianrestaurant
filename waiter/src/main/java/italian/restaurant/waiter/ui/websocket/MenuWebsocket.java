package italian.restaurant.waiter.ui.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import italian.restaurant.waiter.ui.dto.Menu;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class MenuWebsocket {

    private final SimpMessagingTemplate simpleMessagingTemplate;

    public void show(Menu menu) {
        log.info("Showing menu");
        simpleMessagingTemplate.convertAndSend("/topic/menu", menu);
    }

}
