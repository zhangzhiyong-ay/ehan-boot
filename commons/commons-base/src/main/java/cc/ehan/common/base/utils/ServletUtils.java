package cc.ehan.common.base.utils;

import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Servlet 工具类，扩展 hutool 中的 servletUtil
 *
 * @Author ZhangZhiYong
 */
public class ServletUtils extends ServletUtil {


    /**
     * 向response中输出内容
     *
     * @param response
     * @param body
     * @throws IOException
     */
    public static void output(HttpServletResponse response, String body) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(body.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeJson(HttpServletResponse response, String body) {
        write(response,body,MediaType.APPLICATION_JSON_VALUE);
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = getRequestAttributes();
        if (Objects.nonNull(requestAttributes)) {
            return requestAttributes.getRequest();
        }
        return null;
    }

    private static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }
}
