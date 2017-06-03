package italian.restaurant.waiter.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import italian.restaurant.waiter.event.output.RequestMenu;
import italian.restaurant.waiter.ui.dto.Menu;
import italian.restaurant.waiter.ui.websocket.MenuWebsocket;
import italian.restaurant.waiter.ui.websocket.WaiterMessagesWebsocket;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RefreshScope
@RequiredArgsConstructor
public class WaiterService {

    private final RequestMenu requestMenu;

    private final MenuWebsocket menuWebsocket;

    private final WaiterMessagesWebsocket waiterMessagesWebsocket;

    @Value("${waiter.name}")
    @Getter
    private String name;

    public void requestMenu() {
        requestMenu.request(name);
    }

    public void show(Menu menu) {
        waiterMessagesWebsocket.send("Here is the menu. Just tell me what you want to order when you know it.");
        menuWebsocket.show(menu);
    }

}
