package italian.restaurant.waiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WaiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaiterApplication.class, args);
    }

}
