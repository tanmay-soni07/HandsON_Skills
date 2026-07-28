package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.entity.Project;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {

}