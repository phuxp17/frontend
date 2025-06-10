package org.example.backend.repository.admin;

import org.example.backend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
  Optional<Admin> findByEmail(String email);
  boolean existsByEmail(String email);
}