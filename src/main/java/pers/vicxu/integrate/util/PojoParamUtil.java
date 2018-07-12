package pers.vicxu.integrate.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Enumeration;

/**
 * Create by Vic Xu on 7/12/2018
 */
public class PojoParamUtil<T> {
    Class<T> c;

    public static <T> T getObject(HttpServletRequest request, Class<T> c) {
        T t = null;
        try {
            t = c.newInstance();
            @SuppressWarnings("rawtypes")
            Enumeration enumeration = request.getParameterNames();
            Method[] methods = c.getDeclaredMethods();
            while (enumeration.hasMoreElements()) {
                String parma = enumeration.nextElement().toString();
                String setMethod = getSetMethodName(parma);
                for (Method method : methods) {
                    if (setMethod.equalsIgnoreCase(method.getName())) {
                        Class<?> paramType = (method.getParameterTypes())[0];
                        String value = request.getParameter(parma);
                        assignmentParam(t, method, paramType, value);
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    private static String getSetMethodName(String param) {
        return "set" + param.substring(0, 1).toUpperCase() + param.substring(1);
    }

    private static <T> void assignmentParam(T t, Method method, Class<?> paramType, String value) throws InvocationTargetException, IllegalAccessException {
        if (paramType == String.class) {
            method.invoke(t, value);
        } else if (paramType == Integer.class || paramType == int.class) {
            method.invoke(t, Integer.parseInt(value));
        } else if (paramType == Long.class || paramType == long.class) {
            method.invoke(t, Long.parseLong(value));
        } else if (paramType == Boolean.class || paramType == boolean.class) {
            method.invoke(t, Boolean.parseBoolean(value));
        } else if (paramType == Float.class || paramType == float.class) {
            method.invoke(t, Float.parseFloat(value));
        } else if (paramType == Double.class || paramType == double.class) {
            method.invoke(t, Double.parseDouble(value));
        } else if (paramType == Short.class || paramType == short.class) {
            method.invoke(t, Short.parseShort(value));
        } else if (paramType == Character.class || paramType == char.class) {
            method.invoke(t, value.toCharArray()[0]);
        }
    }
}
