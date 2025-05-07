package com.pranali.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pranali.entity.Project;
import com.pranali.repository.ProjectRepository;

@Service
public class ProjectService {
	
	//use projectrepository in projectservices
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getAllProjects(){
		//findAll method which returns list of projects
		return projectRepository.findAll();
	}
	
	// for read-only operation not use of transactional method
		public Project getProject(Long id) {
		   return projectRepository.findById(id).get();
		}

	
	//it would get the project object     for every exception this is parent class
	@Transactional(rollbackForClassName = {"java.lang.exception"})
	public Project saveProject(Project project){
		
		return projectRepository.save(project);
	}
	
	
	@Transactional(rollbackForClassName = {"java.lang.exception"})
	public Project updateProject(Project project){
		
		return projectRepository.save(project);
	}

	
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void deleteProject(Long id) {
	    projectRepository.deleteById(id);
	}
	
	


}
