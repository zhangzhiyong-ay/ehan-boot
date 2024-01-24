package cc.ehan.framework.security;

import cc.ehan.common.base.exception.service.AuthorizedException;
import cc.ehan.framework.security.token.LoginUserInfo;
import cn.hutool.core.util.BooleanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * @Author ZhangZhiYong
 */
@RequiredArgsConstructor
@Component
public class SecurityManager implements InitializingBean {

    public static SecurityManager INSTANCE;

    @Override
    public void afterPropertiesSet() throws Exception {
        INSTANCE = this;
    }

    /**
     * 获取当前操作的用户信息，如果未登录，则抛出异常
     */
    public LoginUserInfo getLoginUserInfoOrThrow() {
        return getLoginUserInfoOptional()
                .orElseThrow(AuthorizedException::new);
    }

    /**
     * 获取当前操作的用户信息，如果未登录，则 Optional 获取值为 null
     **/
    public Optional<LoginUserInfo> getLoginUserInfoOptional() {
        return Optional.of(getAuthentication().getPrincipal()).map(v -> (LoginUserInfo) v);
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 是否为超级管理员
     *
     * @param loginUserInfo 用户信息
     * @return 结果
     */
    public boolean isSuperAdmin(LoginUserInfo loginUserInfo) {
        return Objects.nonNull(loginUserInfo) && BooleanUtil.isTrue(loginUserInfo.getSuperAdmin());
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin(getLoginUserInfoOptional().orElse(null));
    }

}
