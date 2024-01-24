package cc.ehan.common.base.exception.system;

import cc.ehan.common.base.exception.BaseException;

/**
 * @Author ZhangZhiYong
 */
public class SystemException extends BaseException {

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
