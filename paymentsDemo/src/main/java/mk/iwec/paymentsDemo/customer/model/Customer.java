package mk.iwec.paymentsDemo.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;
import mk.iwec.paymentsDemo.location.model.Location;
import mk.iwec.paymentsDemo.payment.model.Payment;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cutomers")

public class Customer extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Payment> payments;

}
