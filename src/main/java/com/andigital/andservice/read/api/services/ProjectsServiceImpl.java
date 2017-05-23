package com.andigital.andservice.read.api.services;

import com.andigital.andservice.read.api.domain.Project;
import com.andigital.andservice.read.api.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aditeja on 5/23/2017.
 */
@Service
public class ProjectsServiceImpl implements ProjectsService {
    @Autowired
    ProjectsRepository projectsRepository;
    /**
     * Default constructor.
     */
    public ProjectsServiceImpl() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public List<Project> getProjects() throws Exception {
        return projectsRepository.findAll();
    }
}
