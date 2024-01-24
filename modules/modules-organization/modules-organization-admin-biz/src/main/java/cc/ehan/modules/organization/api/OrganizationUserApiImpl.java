package cc.ehan.modules.organization.api;

import cc.ehan.modules.organization.api.OrganizationUserApi;
import cc.ehan.modules.organization.api.dto.OrganizationUserInfoResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author ZhangZhiYong
 */
@Component
public class OrganizationUserApiImpl implements OrganizationUserApi {
    @Override
    public OrganizationUserInfoResponseDTO selectUserInfoByUserId(Long userId) {
        return null;
    }
}
