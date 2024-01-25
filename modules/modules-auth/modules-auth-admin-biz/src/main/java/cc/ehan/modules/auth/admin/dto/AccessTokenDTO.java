package cc.ehan.modules.auth.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author zhangzhiyong
 */
@Data
@Accessors(chain = true)
public class AccessTokenDTO {

    private String token;

    private Long userId;

    private LocalDateTime loginTime;

    private String loginIp;
}
