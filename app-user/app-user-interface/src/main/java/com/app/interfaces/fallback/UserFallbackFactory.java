package com.app.interfaces.fallback;

import com.app.interfaces.UserMgrFacade;
import com.app.interfaces.request.UserRequest;
import com.app.interfaces.response.Result;
import com.app.interfaces.response.UserResponse;
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
            public Result<UserResponse> getUserByUserCode(String userCode) {
                UserResponse response = new UserResponse()
                        .setUserCode("999")
                        .setUserName("服务降级后的返回对象");
                return new Result<>(response);
            }

            @Override
            public String getUser(UserRequest request) {
                return null;
            }
        };
    }
}
