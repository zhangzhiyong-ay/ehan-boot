package cc.ehan.framework.security.handle;

import cc.ehan.common.base.constant.constant.MessageSourceCodeStandard;
import cc.ehan.common.base.utils.JsonUtils;
import cc.ehan.common.base.utils.MessageSourceUtils;
import cc.ehan.common.base.utils.ServletUtils;
import cc.ehan.framework.web.response.ResponseResult;
import cn.hutool.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理类 返回未授权 401
 *
 * @Author ZhangZhiYong
 */
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException {
        int code = HttpStatus.HTTP_UNAUTHORIZED;
        String message = MessageSourceUtils.message(MessageSourceCodeStandard.HTTP_UNAUTHORIZED);
        ServletUtils.output(response, JsonUtils.toString(ResponseResult.fail().code(code).message(message)));
    }
}
