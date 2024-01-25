package cc.ehan.modules.organization.mapper;

import cc.ehan.modules.organization.entity.OrganizationRoleEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OrganizationRole)表数据库访问层
 *
 * @author zhangzhiyong
 * @since 2024-01-25 11:42:28
 */
@Mapper
public interface OrganizationRoleMapper extends BaseMapper<OrganizationRoleEntity> {

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrganizationRoleEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrganizationRoleEntity> entities);

}

