package com.pranali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranali.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
