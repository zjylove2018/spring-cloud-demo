package cn.zjy.eureka.eurekaprovide.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:zjy
 * Date:2019/6/12
 * Time:16:15
 * 服务发现-服务提供者
 */
@RestController
public class ProvideController {

    @Value("${provide.message}")
    private String message;

    /**
     * 访问路径:http://localhost:2081/provide/getMessage?name=张三
     * @param name
     * @return
     */
    @RequestMapping("/provide/getMessage")
    public String getMessage(@RequestParam String name){
        return name + ": 欢迎你, 想对你说: " + message;
    }
}
