package cc.ehan.organization.service.user;

import cc.ehan.organization.mapper.user.OrganizationUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author ZhangZhiYong
 */
@Service
@RequiredArgsConstructor
public class OrganizationUserService {

    private final OrganizationUserMapper userMapper;

}
