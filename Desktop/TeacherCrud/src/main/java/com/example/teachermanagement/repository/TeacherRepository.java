package com.example.teachermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teachermanagement.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
