package cc.ehan.organization.entity.user;

import cc.ehan.framework.mybatis.entity.BaseEntity;
import com.mybatisflex.annotation.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author ZhangZhiYong
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("organization_user")
public class OrganizationUserEntity extends BaseEntity {
    /**
     * 用户昵称
     */
    private String name;

    /**
     * 所属部门ID
     */
    private Long departmentId;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户状态：1:正常 | 2:禁用
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 上次登录IP地址
     */
    private String lastLoginIp;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;
}