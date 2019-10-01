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
@FeignClient(value = "app-trade", path = TradeFacade.PATH_PREFIX)
public interface TradeFacade {

    String PATH_PREFIX = "/trade";

    @GetMapping(value = "productTrade")
    String productTrade(@RequestParam(value = "productId") String productId, @RequestParam(value = "uid") String uid);
}
