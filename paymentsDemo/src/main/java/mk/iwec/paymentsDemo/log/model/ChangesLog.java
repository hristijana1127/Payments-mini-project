package mk.iwec.paymentsDemo.log.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;
import mk.iwec.paymentsDemo.payment.model.Payment;
import mk.iwec.paymentsDemo.user.model.User;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangesLog extends BaseEntity {

    @OneToMany(mappedBy = "changesLog")
    public List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    public User user;

    @Column(name = "actions",nullable = false)
    public String action;
    @Column(name = "timestamp", nullable = false)
    public Timestamp timestamp;
    @Column(name ="details", nullable = false)
    public String details;
}
