package com.zpl.dynamic.service.vo;

import lombok.*;

/**
 * @author: pinlin
 * @date: 2022/12/13 9:09
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateReqVO {

    private String userName;

    /**
     * 动态表名后缀
     */
    private String tableNameSuffix;
}
