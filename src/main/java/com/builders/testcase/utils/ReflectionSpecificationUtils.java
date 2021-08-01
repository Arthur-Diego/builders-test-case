package com.builders.testcase.utils;

import com.builders.testcase.annotation.FieldEntity;

import java.lang.reflect.Field;

public class ReflectionSpecificationUtils {

    public static String likeAll(String param){
        return "%"+param+"%";
    }

    public static boolean verifyIsString(Field f) {
        return f.isAnnotationPresent(FieldEntity.class) && !f.getAnnotation(FieldEntity.class).isString();
    }

    public static boolean verifyIsEntityOrEmbbedable(Field f) {
        return f.isAnnotationPresent(FieldEntity.class) && (f.getAnnotation(FieldEntity.class).isEmbbedable() || f.getAnnotation(FieldEntity.class).isEntity());
    }

    public static Object getFieldValue(Object dto, Field f) {
        try {
            f.setAccessible(true);
            return f.get(dto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifyIfFieldIsNull(Object dto, Field f) {
        try {
            f.setAccessible(true);
            return f.get(dto) != null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}
