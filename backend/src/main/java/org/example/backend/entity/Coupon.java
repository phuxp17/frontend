package org.example.backend.entity;

import jakarta.persistence.*;
import org.example.backend.entity.enums.CouponStatus;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.entity.enums.DiscountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "coupons")
public class Coupon extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String code;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = false)
    private DiscountType discountType;

    @Column(name = "discount_value", precision = 10, scale = 2, nullable = false)
    private BigDecimal discountValue;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "is_free_shipping")
    private Boolean isFreeShipping = false;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    @Column(name = "quantity_used")
    private Integer quantityUsed = 0;

    @Column(name = "usage_limit_per_customer")
    private Integer usageLimitPerCustomer = 1;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "min_order_amount", precision = 10, scale = 2)
    private BigDecimal minOrderAmount = BigDecimal.ZERO;

    @Column(name = "max_discount_amount", precision = 10, scale = 2)
    private BigDecimal maxDiscountAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CouponStatus status = CouponStatus.ACTIVE;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL)
    private Set<CouponUsage> couponUsages = new HashSet<>();

    // Getters and setters
}

