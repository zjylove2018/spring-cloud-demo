package cn.zjy.feign.feignconsumer.hystrix;

import cn.zjy.feign.feignconsumer.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:zjy
 * Date:2019/6/18
 * Time:11:48
 * 断路器-Hystrix 当feign服务报错的时候会调用进来
 */
@Component
public class FeignError implements FeignService {

    @Override
    public String welcomeClientOne(String name) {

        //TODO 如果进入了Hystrix断路器方法,会执行一些发送邮件,发送短信给管理员
        //TODO 给请求返回固定的html页面
        return "Hystrix断路器, Feign模块出错, " + name + ":不好意思";
    }
}
