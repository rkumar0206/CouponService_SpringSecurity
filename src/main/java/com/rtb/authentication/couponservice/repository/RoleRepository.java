package com.rtb.authentication.couponservice.repository;

import com.rtb.authentication.couponservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
