package com.app.interfaces.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Feinik
 * @discription
 * @date 2019/9/27
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public class ProductRequest {

    private String uid;
    private String name;
}
