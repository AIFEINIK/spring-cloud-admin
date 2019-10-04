package com.app.interfaces.fallback;

import com.app.interfaces.ProductFacade;
import com.app.interfaces.response.ProductResponse;
import com.app.interfaces.response.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/2
 * @since 1.0.0
 */
@Component
public class ProductFallbackFactory implements FallbackFactory<ProductFacade> {

    @Override
    public ProductFacade create(Throwable cause) {
        return productCode -> new Result<>(new ProductResponse().setProductName("产品服务降级处理"));
    }
}
