package com.vanlang.DAMH_Nhom04_0102.repository;

import com.vanlang.DAMH_Nhom04_0102.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}

