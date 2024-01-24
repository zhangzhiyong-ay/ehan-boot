package cc.ehan.common.base.exception;

import cc.ehan.common.base.utils.MessageSourceUtils;
import cn.hutool.http.HttpStatus;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * @Author ZhangZhiYong
 */

@Accessors(chain = true)
public abstract class BaseException extends RuntimeException {

    private int responseCode = HttpStatus.HTTP_INTERNAL_ERROR;

    private Object responseData;

    private String responseMessage;

    private boolean printLog;

    public BaseException(Throwable cause) {
        super(cause);
        this.printLog = Objects.nonNull(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.printLog = Objects.nonNull(message) || Objects.nonNull(cause);
    }

    public BaseException(String message, Throwable cause, int responseCode, String responseMessageSourceKey, Object... args) {
        this(message, cause);
        this.responseCode = responseCode;
        setResponseMessageWithSourceKey(responseMessageSourceKey, args);
    }

    public BaseException(int responseCode, String responseMessageSourceKey, Object... args) {
        this.responseCode = responseCode;
        setResponseMessageWithSourceKey(responseMessageSourceKey, args);
    }

    public int getResponseCode() {
        return responseCode;
    }

    public BaseException setResponseCode(int responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public Object getResponseData() {
        return responseData;
    }

    public BaseException setResponseData(Object responseData) {
        this.responseData = responseData;
        return this;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public BaseException setResponseMessageWithSourceKey(String responseMessageSourceKey, Object... args) {
        this.responseMessage = MessageSourceUtils.message(responseMessageSourceKey, args);
        return this;
    }


    public boolean isPrintLog() {
        return printLog;
    }

    public BaseException setPrintLog(boolean printLog) {
        this.printLog = printLog;
        return this;
    }
}
