package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cities")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class City extends BaseEntity {
    @Column
    private String name;         // Tên tỉnh/thành

    @Column(name = "country_code", length = 10)
    private String countryCode = "VN";

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<District> districts = new HashSet<>();
}
