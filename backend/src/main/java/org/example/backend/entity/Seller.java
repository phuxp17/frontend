package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sellers")
public class Seller extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "store_description")
    private String storeDescription;

    @Column(name = "seller_rating")
    private Double sellerRating = 0.0;

    @Column(name = "join_date")
    private LocalDateTime joinDate = LocalDateTime.now();

    @Column(name = "is_verified")
    private Boolean isVerified = false;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;


    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

}

