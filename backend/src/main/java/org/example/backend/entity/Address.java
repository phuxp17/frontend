package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    // Nếu bạn chưa có entity User, có thể comment dòng này tạm thời.

    @Column(name = "street_address", nullable = false, length = 500)
    private String streetAddress;

    // Map trực tiếp City (ghi thẳng vào cột city_id khi insert/update)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    // Map trực tiếp District (ghi thẳng vào cột district_id khi insert/update)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @Column(name = "is_default")
    private Boolean isDefault = false;

    @Column(name = "address_type", length = 50)
    private String addressType; // e.g. HOME, WORK, OTHER

}
