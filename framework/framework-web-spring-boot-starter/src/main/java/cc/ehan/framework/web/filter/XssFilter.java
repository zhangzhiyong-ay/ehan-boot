package cc.ehan.framework.web.filter;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/**
 * 防止XSS攻击的过滤器
 *
 * @Author ZhangZhiYong
 */
public class XssFilter implements Filter {
    /**
     * 排除链接
     */
    public Set<String> excludesUrl;

    public AntPathMatcher matcher = new AntPathMatcher();

    public Set<String> excludeMethods = Set.of("GET", "DELETE");

    public XssFilter(Set<String> excludesUrl) {
        this.excludesUrl = excludesUrl;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (isExcludeURL(req)) {
            chain.doFilter(request, response);
            return;
        }
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
        chain.doFilter(xssRequest, response);
    }

    private boolean isExcludeURL(HttpServletRequest request) {
        String url = request.getServletPath();
        String method = request.getMethod();
        // GET DELETE 不过滤
        if (method == null || excludeMethods.contains(method)) {
            return true;
        }
        return CollectionUtil.isNotEmpty(excludesUrl) && excludesUrl.parallelStream().anyMatch(v -> matcher.match(url, v));
    }
}