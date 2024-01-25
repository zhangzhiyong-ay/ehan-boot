package cc.ehan.modules.organization.api;

import cc.ehan.modules.organization.api.response.OrganizationUserInfoApiResponse;
import cc.ehan.modules.organization.api.response.OrganizationUserLoginAccountApiResponse;

/**
 * @Author ZhangZhiYong
 */
public interface OrganizationUserApi {

    /**
     * 根据用户标识查询用户信息
     *
     * @param userId
     * @return
     */
    OrganizationUserInfoApiResponse selectUserInfoByUserId(Long userId);

    /**
     * 根据用户登录账号名查询账号信息
     *
     * @param accountName
     * @return
     */
    OrganizationUserLoginAccountApiResponse selectLoginAccountByAccountName(String accountName);

}
