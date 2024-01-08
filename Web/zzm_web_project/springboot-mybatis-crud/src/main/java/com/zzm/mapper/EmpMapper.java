package com.zzm.mapper;

import com.zzm.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Mingson
 * @version 1.0
 */
@Mapper
public interface EmpMapper {

    // 新增员工
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    // 根据ID删除数据
    // 执行SQL时，会将#{...}替换为?，生成预编译SQL，会自动设置参数值。
    // 使用时机:参数传递，都使用#{...}
    // Preparing: delete from emp where id = ?
    @Delete("delete from emp where id = #{id}")
    // 拼接SQL。直接将参数拼接在SQL语句中，存在SQL注入问题。
    // 使用时机:如果对表名、列表进行动态设置时使用
    // Preparing: delete from emp where id = 1
    // @Delete("delete from emp where id = ${id}")
    public void delete(Integer id);
}
