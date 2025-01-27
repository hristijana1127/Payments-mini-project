package mk.iwec.paymentsDemo.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;
import mk.iwec.paymentsDemo.location.model.Location;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Entity
@Table(name ="banks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank extends BaseEntity {

    private String name;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


}

