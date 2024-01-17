package com.zzm.controller;

import com.zzm.pojo.Dept;
import com.zzm.pojo.Result;
import com.zzm.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@RestController
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)// 指定请求方式为GET
    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @return
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}",id);
        // 调用service删除部门
        deptService.delete(id);
        return Result.success();
    }
}
