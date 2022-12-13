package com.zpl.dynamic.service;

import com.zpl.dynamic.framework.model.UserDO;
import com.zpl.dynamic.service.vo.UserCreateReqVO;
import com.zpl.dynamic.service.vo.UserPageReqVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: pinlin
 * @date: 2022/12/11 21:16
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    /**
     * 存储到sys_user_1表
     *
     * @author zpl
     * @date 2022/12/13 9:21
     */
    @Test
    void testCreateUser1() {
        userService.createUser("zpl", "1");
    }

    /**
     * 存储到 sys_user表，也就是主表
     *
     * @author zpl
     * @date 2022/12/13 9:21
     */
    @Test
    void testCreateUser2() {
        userService.createUser("zpl");
    }

    /**
     * 存储到sys_user_1表
     *
     * @author zpl
     * @date 2022/12/13 9:22
     */
    @Test
    void testCreate3() {
        userService.createUser(UserCreateReqVO.builder().userName("zpl1").tableNameSuffix("1").build());
    }


    /**
     * 查询 sys_user_1中的zpl用户
     *
     * @author zpl
     * @date 2022/12/13 9:22
     */
    @Test
    void testGetUser1() {
        UserDO user = userService.getUser("zpl", "1");
        Assertions.assertNotNull(user);
        System.out.println(user);
    }

    /**
     * 查询 sys_user_1中的zpl用户
     *
     * @author zpl
     * @date 2022/12/13 9:22
     */
    @Test
    void testGetUser2() {
        UserDO user = userService.getUser(UserPageReqVO.builder().userName("zpl").tableNameSuffix("1").build());
        Assertions.assertNotNull(user);
        System.out.println(user);
    }

    /**
     * 查询 sys_user中的zpl用户
     *
     * @author zpl
     * @date 2022/12/13 9:22
     */
    @Test
    void testGetUser3() {
        UserDO user = userService.getUser("zpl");
        Assertions.assertNotNull(user);
        System.out.println(user);
    }
}
