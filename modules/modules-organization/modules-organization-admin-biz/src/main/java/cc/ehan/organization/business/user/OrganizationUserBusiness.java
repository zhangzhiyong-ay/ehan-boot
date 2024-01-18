package cc.ehan.organization.business.user;

import cc.ehan.organization.entity.user.table.OrganizationUserEntityTableDef;
import cc.ehan.organization.service.user.OrganizationUserService;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author ZhangZhiYong
 */
@RequiredArgsConstructor
@Component
public class OrganizationUserBusiness {

    private final OrganizationUserService userService;

}
