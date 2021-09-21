package com.enverny.userservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enverny.userservices.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
