package com.awoniyitechnologies.exertrakapiserver.repositories;

import com.awoniyitechnologies.exertrakapiserver.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
