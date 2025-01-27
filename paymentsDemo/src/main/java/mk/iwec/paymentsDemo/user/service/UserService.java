package mk.iwec.paymentsDemo.user.service;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import mk.iwec.paymentsDemo.user.dto.UserDTO;
import mk.iwec.paymentsDemo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends GenericServiceImpl<UserDTO, User, UUID> {
    public UserService(JpaRepository<User, UUID> repository, GeneralMapper<UserDTO, User> mapper) {
        super(repository, mapper);
    }

}
