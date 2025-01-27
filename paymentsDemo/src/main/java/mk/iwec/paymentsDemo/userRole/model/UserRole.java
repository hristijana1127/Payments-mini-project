package mk.iwec.paymentsDemo.userRole.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;
import mk.iwec.paymentsDemo.user.model.User;

import java.util.Set;

@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends BaseEntity {
    @Column(name = "role_name",nullable = false,unique = true)
    private String roleName;
    @ManyToMany(mappedBy = "userRoles",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users;
}
