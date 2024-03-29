package com.zzm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Mingson
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptLog {
    private Integer id;// ID
    private LocalDateTime createTime;// 创建时间
    private String description;// 描述
}
