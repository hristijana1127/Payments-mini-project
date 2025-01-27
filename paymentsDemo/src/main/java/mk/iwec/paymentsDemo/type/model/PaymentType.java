package mk.iwec.paymentsDemo.type.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;

@Entity
@Table(name ="payment_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentType extends BaseEntity {

    @Column(name = "type", unique = true, nullable = false)
    private String type;
}
