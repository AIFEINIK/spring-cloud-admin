package com.example.demo;

import com.example.demo.request.UserRequest;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Feinik
 * @discription 通过实现FallbackFactory接口的方式来统一处理服务异常问题（服务降级），
 * 而不在通过在每个方法上都加一个@HystrixCommand的方式来实现，这样可以与controller中的业务方法解耦
 * @date 2019/9/30
 * @since 1.0.0
 */
@Component
public class UserFallbackFactory implements FallbackFactory<UserMgrFacade> {

    @Override
    public UserMgrFacade create(Throwable throwable) {
        return new UserMgrFacade() {
            @Override
            public String getUserById(String uid) {
                return "fallback_GetUserById" + uid;
            }

            @Override
            public String getUser(UserRequest request) {
                return "fallback_GetUser" + request.getUid();
            }
        };
    }
}
