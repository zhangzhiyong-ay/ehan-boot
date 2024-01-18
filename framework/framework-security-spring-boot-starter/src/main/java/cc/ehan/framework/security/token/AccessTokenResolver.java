package cc.ehan.framework.security.token;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ZhangZhiYong
 */
@RequiredArgsConstructor
public class AccessTokenResolver {

    private final String headerName;

    public String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader(headerName);

        return accessToken;
    }
}
