package cc.ehan.framework.security.token;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class LoginUserInfo {

    private Long userId;

    private Long deptId;

    private String nickName;

    private Boolean superAdmin;

    private String avatar;

    private List<Long> roleIds;
}
