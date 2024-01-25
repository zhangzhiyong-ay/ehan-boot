package cc.ehan.modules.organization.business;

import cc.ehan.modules.organization.service.OrganizationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author ZhangZhiYong
 */
@RequiredArgsConstructor
@Component
public class OrganizationUserBusiness {

    private final OrganizationUserService organizationUserService;

}
