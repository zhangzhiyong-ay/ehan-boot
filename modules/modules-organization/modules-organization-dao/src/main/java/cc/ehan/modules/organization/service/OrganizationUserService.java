package cc.ehan.modules.organization.service;

import cc.ehan.modules.organization.mapper.OrganizationUserMapper;
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
