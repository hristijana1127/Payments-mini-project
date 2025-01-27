package mk.iwec.paymentsDemo.userRole.repository;


import mk.iwec.paymentsDemo.userRole.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
