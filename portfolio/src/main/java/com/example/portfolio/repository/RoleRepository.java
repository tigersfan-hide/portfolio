package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Byte> {

}
