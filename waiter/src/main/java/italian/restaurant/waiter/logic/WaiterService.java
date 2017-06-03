package italian.restaurant.waiter.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

//@Service
@RefreshScope
public class WaiterService {

    @Value("${waiter.name}")
    private String name;

    public String getName() {
        return name;
    }

}
