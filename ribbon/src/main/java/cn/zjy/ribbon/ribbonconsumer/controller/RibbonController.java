package cn.zjy.ribbon.ribbonconsumer.controller;

import cn.zjy.ribbon.ribbonconsumer.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:zjy
 * Date:2019/6/13
 * Time:10:07
 * 服务消费者——Ribbon
 *   springcloud实现负载均衡:
 *      先启动eureka-server
 *      然后启动eureka-provide
 *      修改eureka-provide端口和入参数据再启动一次
 *      启动ribbon服务
 *      访问多次 http://localhost:2087/hello/cloud?name=zhangzhang
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @RequestMapping("/hello/cloud")
    public String welcomeController(@RequestParam String name){
        return ribbonService.welcomeService(name);
    }
}
