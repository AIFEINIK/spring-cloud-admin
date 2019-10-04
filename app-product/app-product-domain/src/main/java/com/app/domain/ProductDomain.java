package com.app.domain;

import com.app.dao.ProductMapper;
import com.app.dao.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/3
 * @since 1.0.0
 */
@Component
public class ProductDomain {

    @Autowired
    private ProductMapper productMapper;

    public Product getProductByCode(String productCode) {
        return productMapper.getProductByCode(productCode);
    }

}
