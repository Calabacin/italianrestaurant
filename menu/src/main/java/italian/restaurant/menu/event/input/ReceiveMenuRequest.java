package italian.restaurant.menu.event.input;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import italian.restaurant.menu.event.channel.Menu;
import italian.restaurant.menu.logic.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReceiveMenuRequest {

    private final MenuService menuService;

    @StreamListener(Menu.REQUEST_MENU)
    public void receiveMenu(String waiterName) {
        log.info("Menu request performed by: " + waiterName);
        menuService.send(waiterName);
    }

}
