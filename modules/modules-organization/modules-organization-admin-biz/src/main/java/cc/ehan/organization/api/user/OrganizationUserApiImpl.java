package cc.ehan.organization.api.user;

import cc.ehan.organization.api.user.dto.OrganizationUserInfoResponseDTO;
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
