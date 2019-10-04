package com.app.service.impl;

import com.app.common.utils.BeanUtils;
import com.app.dao.entity.Product;
import com.app.domain.ProductDomain;
import com.app.interfaces.enums.ReturnStatusEnum;
import com.app.interfaces.response.ProductResponse;
import com.app.interfaces.response.Result;
import com.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/25
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDomain productDomain;

    @Override
    public Result<ProductResponse> getProductByCode(String productCode) {
        final Product product = productDomain.getProductByCode(productCode);
        if (product == null) {
            return new Result<>(ReturnStatusEnum.PRODUCT_NOT_EXISTS.getValue(), ReturnStatusEnum.PRODUCT_NOT_EXISTS.getName());
        }

        final ProductResponse response = BeanUtils.transform(ProductResponse.class, product, true);
        return new Result<>(response);
    }
}
