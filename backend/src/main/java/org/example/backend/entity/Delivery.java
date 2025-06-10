package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.backend.entity.enums.DeliveryStatus;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliveries")
public class Delivery extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "delivery_person_name")
    private String deliveryPersonName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "service_area")
    private String serviceArea;

    @Column(name = "tracking_number", unique = true)
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status = DeliveryStatus.PENDING;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private Set<OrderTracking> trackingHistory = new HashSet<>();
}
