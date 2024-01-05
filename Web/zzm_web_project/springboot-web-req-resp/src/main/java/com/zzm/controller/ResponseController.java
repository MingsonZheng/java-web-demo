package com.zzm.controller;

import com.zzm.pojo.Address;
import com.zzm.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试响应数据
 *
 * @author Mingson
 * @version 1.0
 */
@RestController
public class ResponseController {

//    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("Hello World~");
//        return "Hello World~";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr() {
//        Address addr = new Address();
//        addr.setProvince("广东");
//        addr.setCity("深圳");
//        return addr;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr() {
//        ArrayList<Address> list = new ArrayList<>();
//
//        Address addr = new Address();
//        addr.setProvince("广东");
//        addr.setCity("深圳");
//
//        Address addr2 = new Address();
//        addr2.setProvince("陕西");
//        addr2.setCity("西安");
//
//        list.add(addr);
//        list.add(addr2);
//        return list;
//    }

    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("Hello World~");
//        return new Result(1, "success", "Hello World~");
        return Result.success("Hello World~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        ArrayList<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("陕西");
        addr2.setCity("西安");

        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }
}
