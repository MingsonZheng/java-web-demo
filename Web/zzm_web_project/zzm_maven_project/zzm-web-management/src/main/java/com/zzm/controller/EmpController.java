package com.zzm.controller;

import com.zzm.anno.Log;
import com.zzm.pojo.Emp;
import com.zzm.pojo.PageBean;
import com.zzm.pojo.Result;
import com.zzm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        if (page == null) page = 1;
//        if (pageSize == null) pageSize = 10;
        log.info("分页查询，参数：{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        // 调用service分页查询
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除操作, ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    @Log
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工, emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询员工信息, id: {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    @Log
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工信息: {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
