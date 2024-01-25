package cc.ehan.modules.auth.admin.api;

import cc.ehan.modules.auth.admin.api.dto.LoginUserInfoResponseDTO;
import cc.ehan.common.base.exception.service.AuthorizedException;

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
