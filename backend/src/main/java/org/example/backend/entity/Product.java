package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.backend.entity.enums.ProductStatus;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity = 0;

    private String unit;

    @Column(nullable = false)
    private Integer sold = 0;

    @Column(precision = 5, scale = 2)
    private BigDecimal discount = BigDecimal.ZERO;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status = ProductStatus.ACTIVE;

    @Column(name = "is_recyclable")
    private Boolean isRecyclable = false;

    @Column(name = "import_date")
    private LocalDate importDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "average_rating")
    private Double averageRating = 0.0;

    @Column(name = "review_count")
    private Integer reviewCount = 0;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductImage> productImages = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();

}
