package italian.restaurant.waiter.event.input;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import italian.restaurant.waiter.event.channel.Menu;
import italian.restaurant.waiter.logic.WaiterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReceiveMenu {

    private final WaiterService waiterService;

    @StreamListener(Menu.MENU)
    public void receiveMenu(italian.restaurant.waiter.ui.dto.Menu menu) {
        log.info("Menu received");
        waiterService.show(menu);
    }

}
