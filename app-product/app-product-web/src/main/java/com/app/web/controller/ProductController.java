package com.app.web.controller;

import com.app.interfaces.ProductFacade;
import com.app.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@RestController
@Slf4j
@RequestMapping(ProductFacade.PATH_PREFIX)
public class ProductController implements ProductFacade {

    @Autowired
    private ProductService productService;

    @Override
    public String getProductById(String id) {
        log.info("获取商品信息，id:{}", id);
        if (id.equals("999")) {
            throw new IllegalArgumentException("商品ID不合法");
        }
        return productService.getProductById(id);
    }
}