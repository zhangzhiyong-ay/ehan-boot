package cc.ehan.framework.web.response;


import cn.hutool.http.HttpStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 操作结果
 *
 * @Author ZhangZhiYong
 */
@Data
@Accessors(chain = true)
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
        return new ResponseResult<>(HttpStatus.HTTP_OK, null, null);
    }

    public static <R> ResponseResult<R> success(R data, String message) {
        return new ResponseResult<>(HttpStatus.HTTP_OK, data, message);
    }

    public static <R> ResponseResult<R> success(R data) {
        return new ResponseResult<>(HttpStatus.HTTP_OK, data, null);
    }

    public static <R> ResponseResult<R> fail(int code, R data, String message) {
        return new ResponseResult<>(code, data, message);
    }

    public static <R> ResponseResult<R> fail(int code, String message) {
        return new ResponseResult<>(code, null, message);
    }

    public static <R> ResponseResult<R> fail(String message) {
        return new ResponseResult<>(HttpStatus.HTTP_INTERNAL_ERROR, null, message);
    }
}
