package italian.restaurant.microservicesdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import be.ordina.msdashboard.EnableMicroservicesDashboardServer;

@EnableDiscoveryClient
@EnableMicroservicesDashboardServer
@SpringBootApplication
public class MicroservicesdashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesdashboardApplication.class, args);
    }
}
