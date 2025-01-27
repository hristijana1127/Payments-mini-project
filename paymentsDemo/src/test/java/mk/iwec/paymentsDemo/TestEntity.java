package mk.iwec.paymentsDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;


@Entity
@Data
@NoArgsConstructor

public class TestEntity {

    @Id
    private UUID id;


    public TestEntity(UUID i) {
    }

    public UUID getId() {
        return id;
    }
}
