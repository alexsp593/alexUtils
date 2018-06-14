package com.alex.config;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @Deception:
 * @Author:Alex
 * @Date:2018年06月10日15点34分
 */
public class AlexConfig {
    public static Logger logger = Logger.getLogger(AlexConfig.class);

    public static Map<String, String> INIT_MAP = new HashMap();

    /*主机特征码*/
    public static final String HOST_FEATURE = INIT_MAP.get("HOST_FEATURE");

    /*日期时间类型格式*/
    public static final String DATETIME_FORMAT = INIT_MAP.get("DATETIME_FORMAT");

    /*日期类型格式*/
    public static final String DATE_FORMAT = INIT_MAP.get("DATE_FORMAT");

    /*时间类型的格式*/
    public static final String TIME_FORMAT = INIT_MAP.get("TIME_FORMAT");

    /**
     * 获取配置信息
     * @param key
     * @return
     */
    public static String get(String key){
        return INIT_MAP.get(key);
    }
}
