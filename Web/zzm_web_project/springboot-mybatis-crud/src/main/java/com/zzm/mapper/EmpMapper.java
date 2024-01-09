package com.zzm.mapper;

import com.zzm.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mingson
 * @version 1.0
 */
@Mapper
public interface EmpMapper {

    // 更新员工
    public void update2(Emp emp);

    // 条件查询员工
//    // 方式一
//    // 模糊匹配使用 ${} 进行拼接，预编译 #{} => ? 不能出行在 '' 中
//    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

//    // 方式二
//    // 解决 性能低、不安全、存在SQL注入问题
//    @Select("select * from emp where name like concat('%', #{name}, '%') and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    // 方式三
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    // 根据ID查询员工
    // // 方案三: 在 application.properties 中开启mybatis的驼峰命名自动映射开关 --- a_column ------> aColumn
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

//    // 方案一: 给字段起别名，让别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getById(Integer id);

//    // 方案二: 通过@Results，@Result注解手动映射封奖
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);

    // 更新员工
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}," +
            "job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

    // 新增员工
    @Options(useGeneratedKeys = true, keyProperty = "id")
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
