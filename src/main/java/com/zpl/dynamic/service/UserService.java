package com.zpl.dynamic.service;

import com.zpl.dynamic.framework.model.UserDO;
import com.zpl.dynamic.service.vo.UserCreateReqVO;
import com.zpl.dynamic.service.vo.UserPageReqVO;

/**
 * @author: pinlin
 * @date: 2022/12/11 20:57
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param userName   用户民
     * @param suffixName 表名后缀(用于动态表名操作)
     * @author zpl
     */
    void createUser(String userName, String suffixName);

    /**
     * 创建用户
     *
     * @param reqVO 请求VO
     * @author zpl
     */
    void createUser(UserCreateReqVO reqVO);


    /**
     * 创建用户
     *
     * @param userName 用户民
     * @author zpl
     */
    void createUser(String userName);

    /**
     * 获取用户
     *
     * @param userName        用户名
     * @param tableNameSuffix 表名后缀
     * @author zpl
     */
    UserDO getUser(String userName, String tableNameSuffix);

    /**
     * 获取用户
     *
     * @param pageReqVO 请求VO
     * @author zpl
     */
    UserDO getUser(UserPageReqVO pageReqVO);

    /**
     * 用户名
     *
     * @param userName 用户名
     * @author zpl
     * @date 2022/12/13 9:23
     */
    default UserDO getUser(String userName) {
        return this.getUser(userName, "");
    }
}
