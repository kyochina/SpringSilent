package com.china.utils.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtil {
    /**
     * 对象转换成JSON字符串
     * @param obj
     * @return
     */
    public static String objToJsonString(Object obj){
        if (obj == null) {
            return "";
        }
        String jsonString = JSONObject.toJSONString(obj);
        return jsonString;
    }

    /**
     * JSON字符串转对象
     * @param jsonString
     * @return
     */
    public static JSONObject JsonStringToObj(String jsonString){
        if (jsonString == null) {
            return null;
        }
        JSONObject obj = JSONObject.parseObject(jsonString);
        return obj;
    }

    /**
     * 数组对象转换成JSON字符串
     * @param listObj
     * @return
     */
    public static String arrayToJsonString(List<Object> listObj){
        if (listObj == null) {
            return "";
        }
        String jsonString = JSONArray.toJSON(listObj).toString();
        return jsonString;
    }
}
