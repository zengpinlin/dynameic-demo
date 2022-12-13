package com.zpl.dynamic.framework.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 动态表名请求参数传递
 *
 * @author: pinlin
 */
public class DynamicTableNameHelper {

    private static final ThreadLocal<String> TABLE_NAMES = new TransmittableThreadLocal<>();

    private DynamicTableNameHelper() {

    }


    public static void set(String stationNo) {
        TABLE_NAMES.set(stationNo);
    }

    public static void remove() {
        TABLE_NAMES.remove();
    }

    public static String get() {
        return TABLE_NAMES.get();
    }
}
