package italian.restaurant.cook.logic;

import org.springframework.stereotype.Service;

import italian.restaurant.cook.domain.Dish;
import italian.restaurant.cook.domain.Order;
import italian.restaurant.cook.events.output.SendDish;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class CookingService {

    private final SendDish sendDish;

    public void cook(Order order) {
        Dish dish = prepareDish(order);
        notifyWaiter(dish);
    }

    private Dish prepareDish(Order order) {
        String name = order.getName();
        try {
            Thread.sleep(10 * 1000);
            log.info("Dish is ready: " + name);
            return createDish(name);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Could not prepare dish: " + name, e);
        }
    }

    private Dish createDish(String name) {
        return Dish.builder()
                   .name(name)
                   .build();
    }

    private void notifyWaiter(Dish dish) {
        sendDish.send(dish);
    }

}
