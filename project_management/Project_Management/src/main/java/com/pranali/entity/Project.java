package com.pranali.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	//each project will have many employee 
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="project_employee",joinColumns = @JoinColumn(name="project_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="employee_id",referencedColumnName = "id"))
	private List<Employee> employees = new ArrayList<>();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="project_task",joinColumns = @JoinColumn(name="project_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="task_id",referencedColumnName = "id"))
	private List<Task> tasks  = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Project(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Project(String name) {
		this.name=name;
	}
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
