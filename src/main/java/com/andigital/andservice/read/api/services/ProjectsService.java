package com.andigital.andservice.read.api.services;

import com.andigital.andservice.read.api.domain.Project;

import java.util.List;

/**
 * Created by aditeja on 5/23/2017.
 */
public interface ProjectsService {

    /**
     * API to return list of Projects
     * @return
     */
    public List<Project> getProjects() throws Exception;

}