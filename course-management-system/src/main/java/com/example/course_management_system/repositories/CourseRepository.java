package com.example.course_management_system.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course_management_system.models.Courses;


@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {

    List<Courses> findByCategory(String category);

    Optional<Courses> findById(int coureId);
    
}
