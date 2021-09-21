package com.enverny.userservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enverny.userservices.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
