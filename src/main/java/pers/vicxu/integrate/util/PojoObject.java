package pers.vicxu.integrate.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by PojoObject on 7/12/2018
 */
public class PojoObject<T> {
    Class<T> c;

    public static <T> T getObject(HttpServletRequest request, Class<T> c) {
        T t = null;
        try {
            t = c.newInstance();
            Enum
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
