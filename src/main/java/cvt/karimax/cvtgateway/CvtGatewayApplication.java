package cvt.karimax.cvtgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CvtGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvtGatewayApplication.class, args);
    }

}
