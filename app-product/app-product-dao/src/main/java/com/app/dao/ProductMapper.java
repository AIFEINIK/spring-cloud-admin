package com.app.dao;

import com.app.dao.entity.Product;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/30
 * @since 1.0.0
 */
public interface ProductMapper {

    Product getProductByCode(String productCode);
}
