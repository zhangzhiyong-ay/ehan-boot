package cc.ehan.modules.organization.mapper;

import java.util.List;

import cc.ehan.modules.organization.entity.OrganizationUserEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * (organization_user)表数据库访问层
 *
 * @author zhangzhiyong
 * @since 2024-01-25 14:25:07
 */
@Mapper
public interface OrganizationUserMapper extends BaseMapper<OrganizationUserEntity> {

    /**
    * 批量新增或按主键更新数据（MyBatis原生foreach方法）
    *
    * @param entities List<OrganizationUserEntity> 实例对象列表
    * @return 影响行数
    * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
    */
    int insertOrUpdateBatch(@Param("entities") List<OrganizationUserEntity> entities);

}

