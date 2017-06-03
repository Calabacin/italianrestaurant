package italian.restaurant.menu.logic;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import italian.restaurant.menu.domain.Dish;
import italian.restaurant.menu.domain.Menu;
import italian.restaurant.menu.event.output.SendMenu;
import lombok.RequiredArgsConstructor;
import scala.util.Random;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final SendMenu sendMenu;

    private Menu menu;

    @PostConstruct
    private void init() {
        menu = new Menu();
        menu.addStarter(Dish.builder()
                            .name("Salad")
                            .build());
        menu.addStarter(Dish.builder()
                            .name("Soup")
                            .build());
        menu.addMain(Dish.builder()
                         .name("Spaguetti Carbonara")
                         .build());
        menu.addMain(Dish.builder()
                         .name("Penne Bolognese")
                         .build());
        menu.addDesert(Dish.builder()
                           .name("Tiramisu")
                           .build());
    }

    public void send(String waiterName) {
        wasteSomeTime();
        sendMenu.send(waiterName, menu);
    }

    private void wasteSomeTime() {
        int randomWait = new Random().nextInt(3);
        int delay = 3 + randomWait;
        try {
            Thread.sleep(delay * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
