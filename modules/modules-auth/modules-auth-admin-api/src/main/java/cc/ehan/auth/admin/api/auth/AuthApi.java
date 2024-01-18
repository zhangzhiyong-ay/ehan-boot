package cc.ehan.auth.admin.api.auth;

import cc.ehan.auth.admin.api.auth.dto.LoginUserInfoResponseDTO;
import cc.ehan.common.exception.service.AuthorizedException;

/**
 * @Author ZhangZhiYong
 */
public interface AuthApi {

    /**
     * 检测 token 状态并返回 token 对应的用户信息
     *
     * @param token
     * @return
     */
    LoginUserInfoResponseDTO checkAccessToken(String token) throws AuthorizedException;
}
