package cc.ehan.modules.organization.api.response;


import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiYong
 */
@Data
public class OrganizationUserInfoApiResponse {

    private Long userId;

    private Long deptId;

    private String nickName;

    private Boolean superAdmin;

    private String avatar;

    private List<Long> roleIds;
}
