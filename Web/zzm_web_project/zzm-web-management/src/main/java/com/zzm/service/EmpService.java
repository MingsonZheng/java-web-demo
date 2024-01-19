package com.zzm.service;

import com.zzm.pojo.Emp;
import com.zzm.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 *
 * @author Mingson
 * @version 1.0
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);
}
