package mk.iwec.paymentsDemo.userRole.service;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import mk.iwec.paymentsDemo.userRole.dto.UserRoleDTO;
import mk.iwec.paymentsDemo.userRole.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserRoleService extends GenericServiceImpl<UserRoleDTO,UserRole, UUID> {

    public UserRoleService(JpaRepository<UserRole, UUID> repository, GeneralMapper<UserRoleDTO, UserRole> mapper) {
        super(repository, mapper);
    }
}
