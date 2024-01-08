package com.zzm.controller;

import com.zzm.pojo.Emp;
import com.zzm.pojo.Result;
import com.zzm.service.EmpService;
import com.zzm.service.impl.EmpServiceA;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mingson
 * @version 1.0
 */
@RestController
public class EmpController {

    // @Resource 与 @Autowired区别
    // @Autowired 是spring框架提供的注解，而@Resource是JDK提供的注解。
    // @Autowired 默认是按照类型注入，而@Resource默认是按照名称注入。

//    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量 - 依赖注入
//    @Qualifier("empServiceA")
//    private EmpService empService;

    @Resource(name = "empServiceB")
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        // 1. 调用service，获取数据
        List<Emp> empList = empService.listEmp();

        // 3. 响应数据
        return Result.success(empList);
    }

//    @RequestMapping("/listEmp")
//    public Result list() {
//        // 1. 加载并解析 emp.xml
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//
//        // 2. 对数据进行转换处理 - gender, job
//        empList.stream().forEach(emp -> {
//            // 处理 gender 1:男，2:女
//            String gender = emp.getGender();
//            if ("1".equals(gender)) {
//                emp.setGender("男");
//            } else if ("2".equals(gender)) {
//                emp.setGender("女");
//            }
//
//            // 处理job - 1: 讲师，2: 班主任 ，3:就业指导
//            String job = emp.getJob();
//            if ("1".equals(job)) {
//                emp.setJob("讲师");
//            } else if ("2".equals(job)) {
//                emp.setJob("班主任");
//            } else if ("3".equals(job)) {
//                emp.setJob("就业指导");
//            }
//        });
//
//        // 3. 响应数据
//        return Result.success(empList);
//    }
}
