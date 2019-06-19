package cn.zjy.feign.feignconsumer.service;

import cn.zjy.feign.feignconsumer.hystrix.FeignError;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IDEA
 * author:zjy
 * Date:2019/6/17
 * Time:11:51
 * feign的服务端
 * Feign是一个声明式的伪Http客户端
 * @FeignClient(value = "eureka-provide")指定要去的服务提供者
 */
@FeignClient(value = "eureka-provide", fallback = FeignError.class)
public interface FeignService {

    /**
     * @RequestMapping(value = "/provide/getMessage")这个路径和他要去的路径要一样
     * 他要去的路径是eureka-provide的controller
     * @param name
     * @return
     */
    @RequestMapping(value = "/provide/getMessage")
    String welcomeClientOne(@RequestParam("name") String name);
}
