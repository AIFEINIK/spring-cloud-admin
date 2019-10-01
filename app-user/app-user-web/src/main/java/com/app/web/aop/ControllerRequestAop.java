package com.app.web.aop;

import com.app.common.utils.ParameterUtil;
import com.app.common.utils.ReflectionUtil;
import com.app.interfaces.annotation.RequiredParam;
import com.app.interfaces.enums.ReturnStatusEnum;
import com.app.interfaces.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author Feinik
 * @discription web controller请求拦截器
 * @date 2019/10/1
 * @since 1.0.0
 */
@Aspect
@Component
@Slf4j
public class ControllerRequestAop {

    @Around("execution(* com.app.web.controller.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object request = null;
        Object[] args = point.getArgs();
        if (ArrayUtils.isNotEmpty(args)) {
            for (Object obj : args) {
                if (!(obj instanceof HttpServletRequest || obj instanceof HttpServletResponse)) {
                    request = obj;
                    break;
                }
            }
        }

        if (request != null) {
            if (!checkRequiredParam(request)) {
                return new Result<>(ReturnStatusEnum.ILLEGAL_ARGUMENT.getValue(),
                        ReturnStatusEnum.ILLEGAL_ARGUMENT.getName());
            }
        }

        return point.proceed();
    }

    private boolean checkRequiredParam(Object request ) {
        Set<Field> fields = ReflectionUtil.getReflections().getFieldsAnnotatedWith(RequiredParam.class);
        try {
            for (Field f : fields) {
                if (ParameterUtil.hasNullOrBlank(f.get(request))) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            log.error("check required param error, cause is:{}", e.getMessage());
        }
        return true;
    }
}
