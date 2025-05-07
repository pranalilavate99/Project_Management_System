package com.pranali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pranali.entity.Project;
import com.pranali.service.ProjectService;



@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	//make one handler
	@GetMapping(value= {"/","home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/getAllProjects")
	public String getAllProjects(Model model) {
		System.out.println("inside controller");
		List<Project> projects = projectService.getAllProjects();
		//provide the project object here
		                       //key value
		model.addAttribute("projects",projects);
		return "projects";
	}
	
	@GetMapping("/addProject")
	public String addProject(Model model) {
		
		model.addAttribute(new Project("ABC"));
		
		 return "add_project";
	}
	
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project project) {
		
	   projectService.saveProject(project);
		 return "redirect:/getAllProjects";
	}
	
	@PostMapping("/updateProject")
	public String updateProject(@ModelAttribute("project") Project project) {
	    projectService.updateProject(project);
	    return "redirect:/getAllProjects";
	}

	
	@GetMapping("/deleteProject/{id}")
	public String deleteProject(@PathVariable(value = "id") Long id) {
		
		 projectService.deleteProject(id);
		
		 return "redirect:/getAllProjects";
	}
	@GetMapping("/editProject/{id}")
	public String editProject(@PathVariable(value = "id") Long id,Model model) {
		
	 Project project = projectService.getProject(id);
	 
	 model.addAttribute(project);
		
		 return "update_project";
	}
	
	

}
