package cc.ehan.modules.organization.api.dto;


import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiYong
 */
@Data
public class OrganizationUserInfoResponseDTO {

    private Long userId;

    private Long deptId;

    private String nickName;

    private Boolean superAdmin;

    private String avatar;

    private List<Long> roleIds;
}
