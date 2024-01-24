package cc.ehan.modules.organization.controller;

import cc.ehan.modules.organization.business.OrganizationUserBusiness;
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
