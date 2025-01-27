package mk.iwec.paymentsDemo.user.mapper;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.user.dto.UserDTO;
import mk.iwec.paymentsDemo.user.model.User;
import mk.iwec.paymentsDemo.userRole.mapper.UserRoleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserRoleMapper.class})
public interface UserMapper extends GeneralMapper<UserDTO, User> {
}
