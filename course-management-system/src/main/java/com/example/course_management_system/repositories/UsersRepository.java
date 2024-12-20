package com.example.course_management_system.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.course_management_system.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT u FROM Users u WHERE u.role = :role")
    List<Users> findByRole(@Param("role") String role);

    Users findByUsername(String username);

}
