package mk.iwec.paymentsDemo.location.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;


@Entity
@Table(name ="locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseEntity {

    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "region",nullable = false)
    private String region;
    @Column(name = "city", nullable = false)
    private String city;



}
