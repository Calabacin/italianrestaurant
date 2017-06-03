package italian.restaurant.waiter.ui.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import italian.restaurant.waiter.logic.WaiterService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RefreshScope
@RequiredArgsConstructor
public class HomeController {

    private final WaiterService waiterService;

    @GetMapping
    public String page() {
        waiterService.requestMenu();
        return "home";
    }

    @ModelAttribute("waiterName")
    public String name() {
        return waiterService.getName();
    }

}
