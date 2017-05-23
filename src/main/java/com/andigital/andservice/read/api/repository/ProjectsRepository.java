package com.andigital.andservice.read.api.repository;

import com.andigital.andservice.read.api.domain.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by aditeja on 5/23/2017.
 */
public interface ProjectsRepository extends MongoRepository<Project, String> {}
