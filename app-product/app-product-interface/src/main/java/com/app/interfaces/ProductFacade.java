package com.app.interfaces;

import com.app.interfaces.fallback.ProductFallbackFactory;
import com.app.interfaces.response.ProductResponse;
import com.app.interfaces.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@FeignClient(value = "app-product", path = ProductFacade.PATH_PREFIX, fallbackFactory = ProductFallbackFactory.class)
public interface ProductFacade {

    String PATH_PREFIX = "/product";

    @GetMapping(value = "getProductByCode/{productCode}")
    Result<ProductResponse> getProductByCode(@PathVariable("productCode") String productCode);
}
