package com.awoniyitechnologies.exertrakapiserver.repositories;

import java.util.List;

import com.awoniyitechnologies.exertrakapiserver.models.Exercise;
import com.awoniyitechnologies.exertrakapiserver.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByParent(Exercise exercise);
    List<Exercise> findByUser(User user);
}
