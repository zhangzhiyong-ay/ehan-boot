package cc.ehan.framework.web.exceptionhandler;

import cc.ehan.common.constant.MessageSourceCodeStandard;
import cc.ehan.common.utils.MessageSourceUtils;
import cc.ehan.framework.web.response.ResponseResult;
import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * 框架异常处理器
 * @Author ZhangZhiYong
 */
@RestControllerAdvice
@Slf4j
@Order()
public class FrameworkExceptionHandler {

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return ResponseResult.fail(
                HttpStatus.HTTP_FORBIDDEN,
                MessageSourceUtils.message(MessageSourceCodeStandard.HTTP_FORBIDDEN));
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException e,
            HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return ResponseResult.fail(
                HttpStatus.HTTP_BAD_METHOD,
                MessageSourceUtils.message(MessageSourceCodeStandard.HTTP_NOT_FOUND, requestURI, e.getMethod()));
    }



    /**
     * 请求路径中缺少必需的路径变量
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseResult handleMissingPathVariableException(MissingPathVariableException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求路径中缺少必需的路径变量'{}',发生系统异常.", requestURI, e);
        return ResponseResult.fail(
                HttpStatus.HTTP_NOT_FOUND,
                MessageSourceUtils.message(MessageSourceCodeStandard.HTTP_NOT_FOUND), requestURI);
    }

    /**
     * 请求参数类型不匹配
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseResult handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求参数类型不匹配'{}',发生系统异常.", requestURI, e);
        return ResponseResult.fail(
                HttpStatus.HTTP_NOT_FOUND,
                MessageSourceUtils.message(MessageSourceCodeStandard.HTTP_NOT_FOUND), requestURI);
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return ResponseResult.fail(
                HttpStatus.HTTP_INTERNAL_ERROR,
                MessageSourceUtils.message(MessageSourceCodeStandard.HTTP_INTERNAL_ERROR));
    }

}
