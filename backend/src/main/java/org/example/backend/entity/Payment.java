package org.example.backend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.enums.PaymentMethod;
import org.example.backend.entity.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "payments")
public class Payment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status = PaymentStatus.PENDING;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "qr_code_url")
    private String qrCodeUrl;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "gateway_response")
    private String gatewayResponse;

    // Getters and setters
}

