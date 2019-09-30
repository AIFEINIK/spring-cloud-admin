package com.example.demo.service.impl;

import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String getProductById(String id) {
        if (id.equals("1000")) {
            return "商品名称：华为Mate30";
        }
        return null;
    }
}
