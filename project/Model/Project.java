package com.example.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    String id;
    String title;
    String description;
    String status;
    String companyName;
}
