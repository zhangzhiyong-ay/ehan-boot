package cc.ehan.framework.web.response;


import cn.hutool.http.HttpStatus;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 操作结果
 *
 * @Author ZhangZhiYong
 */
@Getter
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private T data;

    private String message;

    public ResponseResult(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <R> ResponseResult<R> success() {
        return new ResponseResult<>(HttpStatus.HTTP_OK, null, "success");
    }

    public static <R> ResponseResult<R> fail() {
        return new ResponseResult<>(HttpStatus.HTTP_INTERNAL_ERROR, null, "fail");
    }

    public ResponseResult<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResponseResult<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResponseResult<T> message(String message) {
        this.message = message;
        return this;
    }
}
