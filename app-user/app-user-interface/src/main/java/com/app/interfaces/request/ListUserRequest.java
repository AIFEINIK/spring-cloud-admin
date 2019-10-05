package com.app.interfaces.request;

import com.app.common.page.PageRequest;
import com.app.interfaces.enums.UserStatusEnum;
import lombok.Data;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/4
 * @since 1.0.0
 */
@Data
public class ListUserRequest extends PageRequest {

    private UserStatusEnum status;

    private String userCode;
}
