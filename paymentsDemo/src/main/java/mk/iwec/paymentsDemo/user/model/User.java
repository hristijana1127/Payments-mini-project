package mk.iwec.paymentsDemo.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;
import mk.iwec.paymentsDemo.userRole.model.UserRole;


import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(name = "username",unique = true, nullable = false)
    private String username;
    @Column(name = "password",unique = true, nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<UserRole> userRoles;


}
