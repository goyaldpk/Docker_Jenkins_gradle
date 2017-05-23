/**
 * 
 */
package com.andigital.andservice.read.api.services;

import java.util.List;

import com.andigital.andservice.read.api.domain.SystemProperties;

/**
 * @author premsingh
 *
 */
public interface SystemPropertiesService {
	
	/**
	 * API to return list of System properties
	 * @return
	 */
	public List<SystemProperties> getSystemProperties() throws Exception;

}
