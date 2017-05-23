package com.andigital.andservice.read.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.andigital.andservice.read.api.domain.SystemProperties;

/**
 * @author aditeja
 *
 */
public interface SystemPropertiesRepository extends MongoRepository<SystemProperties, String> {};