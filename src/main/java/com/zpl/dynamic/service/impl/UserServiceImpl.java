package com.zpl.dynamic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zpl.dynamic.framework.annotations.DynamicName;
import com.zpl.dynamic.framework.model.UserDO;
import com.zpl.dynamic.mapper.UserMapper;
import com.zpl.dynamic.service.UserService;
import com.zpl.dynamic.service.vo.UserCreateReqVO;
import com.zpl.dynamic.service.vo.UserPageReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: pinlin
 * @date: 2022/12/11 20:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @DynamicName(spel = "#suffixName")
    public void createUser(String userName, String suffixName) {
        userMapper.insert(this.createUserDO(userName));
    }

    @Override
    @DynamicName(spel = "#reqVO.tableNameSuffix")
    public void createUser(UserCreateReqVO reqVO) {
        userMapper.insert(this.createUserDO(reqVO.getUserName()));
    }

    @Override
    public void createUser(String userName) {
        userMapper.insert(this.createUserDO(userName));
    }

    @Override
    @DynamicName(spel = "#tableNameSuffix")
    public UserDO getUser(String userName, String tableNameSuffix) {
        return userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getName, userName));
    }

    @Override
    @DynamicName(spel = "#pageReqVO.tableNameSuffix")
    public UserDO getUser(UserPageReqVO pageReqVO) {
        return userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getName, pageReqVO.getUserName()));
    }

    private UserDO createUserDO(String userName) {
        UserDO user = new UserDO();
        user.setName(userName);
        return user;
    }
}
