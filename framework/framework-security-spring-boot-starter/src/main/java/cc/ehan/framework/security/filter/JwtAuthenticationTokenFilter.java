package cc.ehan.framework.security.filter;

import cc.ehan.auth.admin.api.auth.AuthApi;
import cc.ehan.auth.admin.api.auth.dto.LoginUserInfoResponseDTO;
import cc.ehan.common.exception.service.AuthorizedException;
import cc.ehan.framework.security.token.AccessTokenResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token过滤器 验证token有效性
 *
 * @Author ZhangZhiYong
 */
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final AuthApi authApi;

    private final AccessTokenResolver accessTokenResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String accessToken = accessTokenResolver.getAccessToken(request);
        try {
            LoginUserInfoResponseDTO loginUserInfo = authApi.checkAccessToken(accessToken);
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(loginUserInfo, null, null);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        } catch (AuthorizedException e) {

        }

    }
}
