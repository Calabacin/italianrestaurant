package italian.restaurant.waiter.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
@RequestMapping("/")
public class HomeController {

    @Value("${waiter.name}")
    private String waiterName;

    @GetMapping
    public String page() {
        return "home";
    }

    @ModelAttribute("waiterName")
    public String name() {
        return waiterName;
    }

}
