package com.zpl.dynamic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zpl.dynamic.framework.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: pinlin
 * @date: 2022/12/11 20:58
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
