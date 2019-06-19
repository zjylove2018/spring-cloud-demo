package cn.zjy.feign.feignconsumer.controller;

import cn.zjy.feign.feignconsumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:zjy
 * Date:2019/6/17
 * Time:13:18
 * feign的服务端
 * Feign是一个声明式的伪Http客户端
 * springcloud实现负载均衡:
 *    一:正常测试
 *      先启动eureka-server
 *      然后启动eureka-provide
 *      修改eureka-provide端口和入参数据再启动一次
 *      启动feign服务
 *      访问多次 http://localhost:2086/provide/getMessage?name=dddddd
 *    二:断路器测试
 *      先启动eureka-server服务
 *      然后启动eureka-provide服务
 *      启动feign服务
 *      访问 http://localhost:2086/provide/getMessage?name=dddddd (正常显示)
 *      关闭掉eureka-provide服务
 *      访问 http://localhost:2086/provide/getMessage?name=dddddd (异常显示)
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    /**
     * @RequestMapping(value = "/provide/getMessage")这个路径和他要去的路径要一样
     * 他要去的路径是eureka-provide的controller
     * @param name
     * @return
     * 访问路径为:http://localhost:2086/provide/getMessage?name=dddddd
     */
    @RequestMapping("/provide/getMessage")
    public String getMessage(@RequestParam(value = "name", required = true) String name){
        return feignService.welcomeClientOne(name);
    }
}
