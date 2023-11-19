package com.example.student1.Controller;

import com.example.student1.API.ApiResponse;
import com.example.student1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student>students=new ArrayList<>();
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student s){
        students.add(s);
        return new ApiResponse("student added",200);
    }
    @GetMapping("/getName/{index}")
    public String getNames(@PathVariable int index){
        return students.get(index).getName();
    }
    @GetMapping("/getAge/{index}")
    public int getAge(@PathVariable int index){
        return students.get(index).getAge();
    }
    @GetMapping("/college/degree/{index}")
    public String getDegree(@PathVariable int index){
      return students.get(index).getDegree();
    }
    @GetMapping("/getStatus/{index}")
    public boolean getStatus(@PathVariable int index){
        if (students.get(index).getStatus().equals("graduated")){
            return true;
        } else return false;
    }
    @GetMapping("/students")
    public ArrayList getStudent(){
        return students;
    }
}
