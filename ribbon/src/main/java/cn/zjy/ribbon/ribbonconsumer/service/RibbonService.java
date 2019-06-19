package cn.zjy.ribbon.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IDEA
 * author:zjy
 * Date:2019/6/13
 * Time:10:04
 *  服务消费者——Ribbon
 *  springcloud实现负载均衡:
 *      先启动eureka-server
 *      然后启动eureka-provide
 *      修改eureka-provide端口和入参数据再启动一次
 *      启动ribbon服务
 *      访问多次 http://localhost:2082/hello/cloud?name=zhangzhang
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @HystrixCommand 断路器注解,指定断路会调用error()方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    public String welcomeService(String name){
        //此url内容为:http://(客户端spring.application.name名称:eureka-provide)/(要跳到的请求:provide/getMessage)
        return restTemplate.getForObject("http://eureka-provide/provide/getMessage?name=" + name, String.class);
    }

    /**
     * 此方法是配合上一个方法实现断路器调用的方法.
     * @param name
     * @return
     */
    public String error(String name){

        //TODO 如果程序调用了error方法,则可以实现发送邮件,发送短信业务来提醒服务器出现故障
        return "出错了! " + name + "断路器起作用了!";
    }
}
