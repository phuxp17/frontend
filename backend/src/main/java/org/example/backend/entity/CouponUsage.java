package org.example.backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coupon_usages")
public class CouponUsage extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "used_at")
    private LocalDateTime usedAt = LocalDateTime.now();

    @Column(name = "discount_applied", precision = 10, scale = 2)
    private BigDecimal discountApplied;

    // Getters and setters
}

