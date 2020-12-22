package com.awoniyitechnologies.exertrakapiserver.repositories;

import java.util.List;

import com.awoniyitechnologies.exertrakapiserver.models.Routine;
import com.awoniyitechnologies.exertrakapiserver.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findByUser(User user);
}
