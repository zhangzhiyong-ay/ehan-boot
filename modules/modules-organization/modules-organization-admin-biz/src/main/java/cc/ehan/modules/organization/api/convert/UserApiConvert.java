package cc.ehan.modules.organization.api.convert;

import cc.ehan.common.base.utils.BeanUtils;
import cc.ehan.modules.organization.api.response.OrganizationUserLoginAccountApiResponse;
import cc.ehan.modules.organization.dto.LoginAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

import static cc.ehan.modules.organization.constants.OrganizationUserStateStandard.NORMAL;

/**
 * @author zhangzhiyong
 */
@Mapper
public interface UserApiConvert {

    UserApiConvert INSTANCE = Mappers.getMapper(UserApiConvert.class);

    default OrganizationUserLoginAccountApiResponse loginAccount(LoginAccountDTO loginAccountDTO) {
        OrganizationUserLoginAccountApiResponse response = BeanUtils.copyPropertiesByClass(loginAccountDTO, OrganizationUserLoginAccountApiResponse.class);
        response.setEnabled(Objects.equals(NORMAL, loginAccountDTO.getState()));
        return response;
    }
}
