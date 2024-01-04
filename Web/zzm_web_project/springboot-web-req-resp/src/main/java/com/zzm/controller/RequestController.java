package com.zzm.controller;

import com.zzm.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试请求参数接收
 *
 * @author Mingson
 * @version 1.0
 */
@RestController
public class RequestController {

//    // 原始方式
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request) {
//        // 获取请求参数
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name + ":" + age);
//        return "OK";
//    }

//    // springboot方式
//    // 简单参数:参数名与形参变量名相同，定义形参即可接收参数。
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name, Integer age) {
//        System.out.println(name + ":" + age);
//        return "OK";
//    }

    // springboot方式
    // 简单参数:如果方法形参名称与请求参数名称不匹配，可以使用 @RequestParam 完成映射。
    // 注意事项
    // @RequestParam中的required属性默认为true，代表该请求参数必须传递，如果不传递将报错。
    // 如果该参数是可选的，可以将required属性设置为false。
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name", required = false) String username, Integer age) {
        System.out.println(username + ":" + age);
        return "OK";
    }

    // 2. 实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "OK";
    }
}
