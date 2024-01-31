package cc.ehan.framework.security.token;

import cc.ehan.common.base.utils.ServletUtils;
import cc.ehan.framework.security.config.properties.AuthorizationProperties;
import cc.ehan.framework.security.token.generator.TokenGenerator;
import cc.ehan.framework.security.token.generator.UUIDTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * token 会话管理器
 *
 * @author zhangzhiyong
 */
@RequiredArgsConstructor
public class TokenManager {

    private final RedissonClient redissonClient;

    private final AuthorizationProperties authorizationProperties;

    private TokenGenerator tokenGenerator = new UUIDTokenGenerator();

    public String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader(authorizationProperties.getHeaderName());
        return accessToken;
    }

    public AccessToken createToken(Long userId) {
        Long tokenExpireTime = authorizationProperties.getTokenExpireTime();
        LocalDateTime loginTime = LocalDateTime.now();
        String tokenUUID = tokenGenerator.generator(userId);
        AccessToken accessTokenDTO = new AccessToken()
                .setToken(tokenUUID)
                .withLoginTime(loginTime)
                .withExpireTimestamp(loginTime.minusMinutes(authorizationProperties.getTokenExpireTime()))
                .setUserId(userId);

        HttpServletRequest request = ServletUtils.getRequest();
        if (Objects.nonNull(request)) {
            String clientIP = ServletUtils.getClientIP(request);
            accessTokenDTO.setLoginIp(clientIP);
        }

        RBucket<AccessToken> tokenCache = redissonClient.getBucket(cacheKey(tokenUUID));
        tokenCache.set(accessTokenDTO, tokenExpireTime, TimeUnit.MINUTES);
        return accessTokenDTO;
    }

    private String cacheKey(String token) {
        return authorizationProperties.getTokenCacheKey() + ":" + token;
    }

}
