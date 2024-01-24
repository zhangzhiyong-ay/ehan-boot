package cc.ehan.modules.organization.api;

import cc.ehan.modules.organization.api.dto.OrganizationUserInfoResponseDTO;

/**
 * @Author ZhangZhiYong
 */
public interface OrganizationUserApi {

    OrganizationUserInfoResponseDTO selectUserInfoByUserId(Long userId);

}
