package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "districts",
        uniqueConstraints = @UniqueConstraint(columnNames = {"city_id", "id"}))
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class District extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "district_name")
    private String districtName;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses = new HashSet<>();
}
