package cc.ehan.modules.auth.admin.security;

import cc.ehan.common.base.utils.ServletUtils;
import cc.ehan.framework.security.config.properties.AuthorizationProperties;
import cc.ehan.modules.auth.admin.dto.AccessTokenDTO;
import cn.hutool.core.lang.UUID;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * token 会话管理器
 *
 * @author zhangzhiyong
 */
@Component
@RequiredArgsConstructor
public class TokenManager {

    private final RedissonClient redissonClient;

    private final AuthorizationProperties authorizationProperties;

    public AccessTokenDTO createToken(Long userId) {
        String tokenUUID = UUID.randomUUID().toString(true);
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO()
                .setToken(tokenUUID)
                .setLoginTime(LocalDateTime.now())
                .setUserId(userId);

        HttpServletRequest request = ServletUtils.getRequest();
        if (Objects.nonNull(request)) {
            String clientIP = ServletUtils.getClientIP(request);
            accessTokenDTO.setLoginIp(clientIP);
        }
        return accessTokenDTO;
    }
}
