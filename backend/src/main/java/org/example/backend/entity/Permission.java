package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter@NoArgsConstructor @AllArgsConstructor
@Table(name = "permissions")
public class Permission extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

