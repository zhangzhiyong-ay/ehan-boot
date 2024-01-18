package cc.ehan.common.exception.service;

import cc.ehan.common.constant.MessageSourceCodeStandard;
import cc.ehan.common.exception.BaseException;
import cn.hutool.http.HttpStatus;

/**
 * 未登录认证异常
 *
 * @Author ZhangZhiYong
 */
public class AuthorizedException extends BaseException {
    public AuthorizedException() {
        super(HttpStatus.HTTP_UNAUTHORIZED, MessageSourceCodeStandard.HTTP_UNAUTHORIZED);
    }

    public AuthorizedException(int responseCode, String responseMessageSourceKey, Object... args) {
        super(responseCode, responseMessageSourceKey, args);
    }
}
