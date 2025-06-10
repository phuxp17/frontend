package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Table(name = "roles")
public class Role extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "role")
    private Set<Permission> permissions = new HashSet<>();
}