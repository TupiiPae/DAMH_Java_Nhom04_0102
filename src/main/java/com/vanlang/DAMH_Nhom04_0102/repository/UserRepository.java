package com.vanlang.DAMH_Nhom04_0102.repository;

import com.vanlang.DAMH_Nhom04_0102.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

