package cc.ehan.organization.controller.user;

import cc.ehan.organization.business.user.OrganizationUserBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZhangZhiYong
 */
@RestController
@RequiredArgsConstructor
public class OrganizationUserController {

    private final OrganizationUserBusiness userBusiness;

}
