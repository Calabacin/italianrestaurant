package italian.restaurant.waiter.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/constantflow")
public class ConstantFlowController {

    @GetMapping
    public String page() {
        return "constantflow";
    }

}
