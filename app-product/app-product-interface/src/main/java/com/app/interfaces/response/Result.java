package com.app.interfaces.response;

import com.app.common.page.Page;
import com.app.interfaces.enums.ReturnStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@NoArgsConstructor
public class Result<T> {

    private int status = ReturnStatusEnum.SUCCESS.getValue();
    private String message = ReturnStatusEnum.SUCCESS.getName();

    private T data;

    public Result(T data) {
        this.data = data;
    }

    public Result(int status, String message) {
        this.setStatus(status);
        this.message = message;
    }

    public Result(int status, String message, T data) {
        this.setStatus(status);
        this.message = message;
        this.data = data;
    }

    public static Result emptyPageResult() {
        return new Result(new Page(0, Collections.emptyList()));
    }
}
