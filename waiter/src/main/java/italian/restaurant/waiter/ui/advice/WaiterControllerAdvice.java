package italian.restaurant.waiter.ui.advice;

import org.springframework.web.bind.annotation.ModelAttribute;

import italian.restaurant.waiter.logic.WaiterService;
import lombok.RequiredArgsConstructor;

//@ControllerAdvice(basePackages = "italian.restaurant.waiter.ui.controller")
@RequiredArgsConstructor
public class WaiterControllerAdvice {

    private final WaiterService waiterService;

    @ModelAttribute("waiterName")
    public String name() {
        return waiterService.getName();
    }

}
