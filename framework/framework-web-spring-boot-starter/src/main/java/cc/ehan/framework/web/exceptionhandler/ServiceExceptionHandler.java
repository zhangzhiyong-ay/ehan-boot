package cc.ehan.framework.web.exceptionhandler;

import cc.ehan.common.constant.MessageSourceCodeStandard;
import cc.ehan.common.exception.BaseException;
import cc.ehan.common.utils.MessageSourceUtils;
import cc.ehan.common.utils.StringUtils;
import cc.ehan.framework.web.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 业务异常处理器
 *
 * @Author ZhangZhiYong
 */
@RestControllerAdvice
@Slf4j
@Order(1)
public class ServiceExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult handleServiceException(BaseException e, HttpServletRequest request) {
        if (e.isPrintLog()) {
            String requestURI = request.getRequestURI();
            log.error("请求异常，请求地址：'{}'，异常信息：'{}'", requestURI, e.getMessage(), e);
        }
        int code = e.getResponseCode();
        Object data = e.getResponseData();
        String message = e.getResponseMessage();
        if (StringUtils.isEmpty(message)) {
            message = MessageSourceUtils.message(MessageSourceCodeStandard.HTTP_FORBIDDEN);
        }
        return ResponseResult.fail(code, data, message);
    }
}
