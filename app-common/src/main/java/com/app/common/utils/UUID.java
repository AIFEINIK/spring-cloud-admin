package com.app.common.utils;

/**
 * @author Feinik
 * @Discription
 * @Version 1.0.0
 */
public class UUID {

    public UUID() {
    }

    public static String get() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

}
