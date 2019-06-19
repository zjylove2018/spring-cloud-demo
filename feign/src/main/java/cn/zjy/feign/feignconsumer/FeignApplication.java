package cn.zjy.feign.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign是一个声明式的伪Http客户端
 */
@SpringBootApplication
@EnableFeignClients //标明这是feign
@EnableDiscoveryClient
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
