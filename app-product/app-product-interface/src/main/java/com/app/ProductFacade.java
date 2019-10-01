package com.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@FeignClient(value = "app-product", path = ProductFacade.PATH_PREFIX)
public interface ProductFacade {

    String PATH_PREFIX = "/product";

    @GetMapping(value = "getProductById")
    String getProductById(@RequestParam(value = "id") String id);
}
