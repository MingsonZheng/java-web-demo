package com.zzm.controller;

import com.zzm.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

    // 3. 数组集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    // 4. 日期时间参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "Ok";
    }

    // 5. json 参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "Ok";
    }

    // 6. 路径参数
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }
}
