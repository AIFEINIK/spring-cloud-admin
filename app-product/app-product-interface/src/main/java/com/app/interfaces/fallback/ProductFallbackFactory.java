package com.app.interfaces.fallback;

import com.app.interfaces.ProductFacade;
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
        return (ProductFacade) id -> {
            return "fallbackProduct" + id;
        };
    }
}
