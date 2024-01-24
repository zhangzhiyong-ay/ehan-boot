package cc.ehan.framework.web.filter;

import cc.ehan.common.base.utils.StringUtils;
import cc.ehan.framework.web.servlet.BufferedServletInputStream;
import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HTMLFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * XSS过滤处理
 *
 *  zhangzhiyong
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    /**
     * @param request
     */
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (Objects.nonNull(value)) {
            HTMLFilter htmlFilter = new HTMLFilter();
            value = htmlFilter.filter(value).trim();
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (Objects.nonNull(values)) {
            int length = values.length;
            String[] escapesValues = new String[length];
            HTMLFilter htmlFilter = new HTMLFilter();
            for (int i = 0; i < length; i++) {
                // 防xss攻击和过滤前后空格
                escapesValues[i] = htmlFilter.filter(values[i]).trim();
            }
            return escapesValues;
        }
        return null;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ServletInputStream inputStream = super.getInputStream();
        // 非json类型，直接返回
        if (!isJsonRequest()) {
            return inputStream;
        }

        // 为空，直接返回
        String bodyStringValue = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        if (StringUtils.isEmpty(bodyStringValue)) {
            return inputStream;
        }

        // xss过滤
        bodyStringValue = new HTMLFilter().filter(bodyStringValue).trim();
        byte[] body = bodyStringValue.getBytes(StandardCharsets.UTF_8);
        return new BufferedServletInputStream(body, inputStream);
    }

    /**
     * 是否是Json请求
     */
    public boolean isJsonRequest() {
        String header = super.getHeader(HttpHeaders.CONTENT_TYPE);
        return StringUtils.startWithIgnoreCase(header, MediaType.APPLICATION_JSON_VALUE);
    }
}