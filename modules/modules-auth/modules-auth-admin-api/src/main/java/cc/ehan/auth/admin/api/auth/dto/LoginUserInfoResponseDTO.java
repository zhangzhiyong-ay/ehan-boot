package cc.ehan.auth.admin.api.auth.dto;


import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiYong
 */
@Data
public class LoginUserInfoResponseDTO {

    private Long userId;

    private Long deptId;

    private String nickName;

    private Boolean superAdmin;

    private String avatar;

    private List<Long> roleIds;
}
