package cn.zjy.eureka.eurekaprovide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvideApplication.class, args);
    }

}
