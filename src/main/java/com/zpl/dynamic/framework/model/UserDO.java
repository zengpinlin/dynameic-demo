package com.zpl.dynamic.framework.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: pinlin
 * @date: 2022/12/11 20:56
 */
@Data
@TableName("sys_user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    @TableId
    private Long id;

    private String name;
}
