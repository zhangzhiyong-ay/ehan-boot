package cc.ehan.common.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Servlet 工具类
 *
 * @Author ZhangZhiYong
 */
public class ServletUtils {


    /**
     * 向response中输出内容
     *
     * @param response
     * @param body
     * @throws IOException
     */
    public static void output(HttpServletResponse response, String body) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(body.getBytes(StandardCharsets.UTF_8));
    }
}
