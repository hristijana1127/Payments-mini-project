package mk.iwec.paymentsDemo.payment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.iwec.paymentsDemo.bank.model.Bank;
import mk.iwec.paymentsDemo.customer.model.Customer;
import mk.iwec.paymentsDemo.infrastructure.model.BaseEntity;
import mk.iwec.paymentsDemo.location.model.Location;
import mk.iwec.paymentsDemo.log.model.ChangesLog;
import mk.iwec.paymentsDemo.type.model.PaymentType;


import java.time.LocalDateTime;
@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Payment extends BaseEntity {
    @Column(name="date_time",nullable = false)
    private LocalDateTime dateTime;
    @Column(name="amount",nullable = false)
    private float amount;
    @Column(name = "note",nullable = true)
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentType_id",nullable = false)
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_id",nullable = false)
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "changes_log_id")
    private ChangesLog changesLog;
}
