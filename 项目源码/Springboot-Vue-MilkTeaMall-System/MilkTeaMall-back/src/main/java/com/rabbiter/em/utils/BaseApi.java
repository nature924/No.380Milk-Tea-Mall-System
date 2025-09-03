package com.rabbiter.em.utils;

import java.util.HashMap;
import java.util.Map;

public class BaseApi {
    private static Map<String, Object> map(String code, Object data, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("data", data);
        map.put("msg", msg);
        return map;
    }

    public static Map<String, Object> success() {
        return map("200", null, null);
    }

    public static Map<String, Object> success(Object data) {
        return map("200", data, null);
    }

    public static Map<String, Object> error(String msg) {
        return map("400", null, msg);
    }

}
