package com.example.project.Controller;

import com.example.project.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    ArrayList<Project>projects=new ArrayList<>();
    @PostMapping("/add")
    public String addProject(@RequestBody Project p){
        projects.add(p);
        return "project added";
    }
    @GetMapping("/display")
    public ArrayList addProject(){
        return projects;
    }
    @PutMapping("/update/{index}")
    public String updateProject(@PathVariable int index,@RequestBody Project p){
        projects.set(index,p);
        return "Project updated";
    }
    @DeleteMapping("/delete/{index}")
    public String deleteProject(@PathVariable int index){
        projects.remove(index);
        return "project deleted";
    }
    @PutMapping("/change/{index}")
    public String changeProject(@PathVariable int index){
        if(projects.get(index).getStatus().equals("done")){
            projects.get(index).setStatus("not done");
        } else projects.get(index).setStatus("done");
        return "status changed";
    }
    @GetMapping("/search/{title}")
    public String searchProject(@PathVariable String title){
        for(Project p:projects){
            if(p.getTitle().equals(title)){
                return "project :"+p;
            }
        }
       return "not found";
    }
    ArrayList<Project>projectsCompany=new ArrayList<>();
    @GetMapping("/company/{name}")
    public ArrayList projectCompany(@PathVariable String name){
        for(Project p:projects){
            if(p.getCompanyName().equals(name)){
                projectsCompany.add(p);
            }
        }
        return projectsCompany;
    }
}
