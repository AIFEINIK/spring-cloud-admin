package com.app.common.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/1
 * @since 1.0.0
 */
public class ParameterUtil {
    private ParameterUtil() {

    }

    public static boolean hasNullOrBlank(Object... params) {
        if (ArrayUtils.isEmpty(params)) {
            return true;
        }

        for (Object obj : params) {
            if (obj == null) {
                return true;
            }
            if ((obj instanceof Collection<?> || obj instanceof Object[])
                    && CollectionUtils.sizeIsEmpty(obj)) {
                return true;
            }
            if (obj instanceof String && StringUtils.isBlank(obj.toString())) {
                return true;
            }
        }

        return false;
    }
}
