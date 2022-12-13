package com.zpl.dynamic.framework.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.zpl.dynamic.framework.context.DynamicTableNameHelper;
import org.springframework.util.StringUtils;

/**
 * 动态表名处理器
 *
 * @author: pinlin
 */
public class DynamicTableNameHandler implements TableNameHandler {

    @Override
    public String dynamicTableName(String sql, String tableName) {
        String tableNameSuffix = DynamicTableNameHelper.get();
        if (StringUtils.hasText(tableNameSuffix)) {
            return tableName + "_" + tableNameSuffix;
        }
        return tableName;
    }
}
