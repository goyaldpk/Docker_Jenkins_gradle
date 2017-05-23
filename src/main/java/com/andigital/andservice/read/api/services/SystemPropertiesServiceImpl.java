/**
 * 
 */
package com.andigital.andservice.read.api.services;

import java.util.List;

import com.andigital.andservice.read.api.repository.SystemPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andigital.andservice.read.api.domain.SystemProperties;

/**
 * @author premsingh
 * Implementation class for SystemPropertiesService interface.
 */
@Service
public class SystemPropertiesServiceImpl implements SystemPropertiesService {

	@Autowired
	SystemPropertiesRepository systemPropertiesRepository;
	/**
	 * Default constructor.
	 */
	public SystemPropertiesServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see com.andigital.andservice.read.api.services.DashboardService#getSystemProperties()
	 */
	@Override
	public List<SystemProperties> getSystemProperties() throws Exception {
		return systemPropertiesRepository.findAll();
	}

}
