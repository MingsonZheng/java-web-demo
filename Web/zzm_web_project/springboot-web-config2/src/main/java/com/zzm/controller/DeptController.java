package com.zzm.controller;

import com.zzm.pojo.Dept;
import com.zzm.pojo.Result;
import com.zzm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理
 *
 * @author Mingson
 * @version 1.0
 */
//@Lazy //延迟初始化
@Scope("prototype")
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    public DeptController() {
        System.out.println("DeptController constructor ...");
    }

    /**
     * 查询部门数据
     * @return
     */
    @GetMapping
    public Result list() {
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }

    @PutMapping()
    public Result edit(@RequestBody Dept dept) {
        deptService.getById(dept.getId());
        return Result.success();
    }
}
