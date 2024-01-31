package com.zzm.mapper;

import com.zzm.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Mingson
 * @version 1.0
 */
@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(create_time, description) values (#{createTime}, #{description})")
    void insert(DeptLog deptLog);
}
