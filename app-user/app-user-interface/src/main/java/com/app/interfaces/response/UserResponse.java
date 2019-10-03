package com.app.interfaces.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/3
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserResponse implements Serializable {

    /** 用户编号 */
    private String userCode;

    /** 用户名 */
    private String userName;

    /** email */
    private String email;

    /** 创建时间 */
    private String createTime;

    /** 更新时间 */
    private String updateTime;
}
