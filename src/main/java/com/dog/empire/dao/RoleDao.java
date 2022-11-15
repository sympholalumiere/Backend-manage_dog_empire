package com.dog.empire.dao;

import com.dog.empire.model.ERole;
import com.dog.empire.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
