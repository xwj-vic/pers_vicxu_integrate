package pers.vicxu.integrate.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.TimeZone;

/**
 * Create by JsonUtil on 7/12/2018
 */
public class JsonUtil {
    private static ObjectMapper mapper;

    static {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public static String parseObject2Json(Object obj) throws Exception {
        return mapper.writeValueAsString(obj);
    }


}
