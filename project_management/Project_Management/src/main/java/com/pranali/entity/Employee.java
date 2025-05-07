package com.pranali.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="emp_name")
	private String name;
	
	//one employee will have many no of tasks
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="employee_task",joinColumns = @JoinColumn(name="employee_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="task_id",referencedColumnName = "id"))
	private List<Task> tasks = new ArrayList<>();
	
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
	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employee() {
	
		super();
		// TODO Auto-generated constructor stub
	}
	

}
