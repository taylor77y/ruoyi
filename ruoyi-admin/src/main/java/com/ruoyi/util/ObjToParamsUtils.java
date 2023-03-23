package com.ruoyi.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象转换params
 * @author Krson
 * @date 2023/1/11 21:25
 */
public class ObjToParamsUtils {

    public static String change(Class<?> clazz,Object obj){
        StringBuilder builder = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName =  fields[i].getName();
            if (i != 0 && i != 1){
                if (i == fields.length-1){
                    builder.append(fieldName).append("=").append(getValueByFieldName(fieldName,obj));
                }else {
                    builder.append(fieldName).append("=").append(getValueByFieldName(fieldName,obj)).append("&");
                }
            }
        }
        return builder.toString();
    }
    private static Object getValueByFieldName(String fieldName,Object object){
        String firstLetter=fieldName.substring(0,1).toUpperCase();
        String getter = "get"+firstLetter+fieldName.substring(1);
        try {
            Method method = object.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(object, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}
