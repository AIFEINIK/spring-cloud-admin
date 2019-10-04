package com.app.common.utils;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/1
 * @since 1.0.0
 */
public class ReflectionUtil {

    private static Reflections reflections = new Reflections(new ConfigurationBuilder()
            .forPackages("com.app")
            .addScanners(new SubTypesScanner())
            .addScanners(new FieldAnnotationsScanner())
            .addScanners(new MethodAnnotationsScanner())
            .addScanners(new MethodParameterScanner()));

    public ReflectionUtil() {
    }

    public static Reflections getReflections() {
        return reflections;
    }
}
