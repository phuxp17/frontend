package org.example.backend.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.enums.DeliveryStatus;

import java.time.LocalDateTime;
@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "order_tracking")
public class OrderTracking extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    private String location;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp = LocalDateTime.now();

    private String notes;

}
