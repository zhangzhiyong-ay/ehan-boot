package cc.ehan.organization.api.user;

import cc.ehan.organization.api.user.dto.OrganizationUserInfoResponseDTO;

/**
 * @Author ZhangZhiYong
 */
public interface OrganizationUserApi {

    OrganizationUserInfoResponseDTO selectUserInfoByUserId(Long userId);

}
