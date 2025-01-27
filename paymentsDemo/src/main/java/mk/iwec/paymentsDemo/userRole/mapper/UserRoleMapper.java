package mk.iwec.paymentsDemo.userRole.mapper;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.user.mapper.UserMapper;
import mk.iwec.paymentsDemo.userRole.dto.UserRoleDTO;
import mk.iwec.paymentsDemo.userRole.model.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses ={UserMapper.class})
public interface UserRoleMapper extends GeneralMapper<UserRoleDTO, UserRole> {
}
