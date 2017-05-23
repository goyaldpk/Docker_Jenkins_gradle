/**
 * 
 */
package com.andigital.andservice.read.api.controller;

import java.util.Date;
import java.util.List;

import com.andigital.andservice.read.api.ANDRestServiceException;
import com.andigital.andservice.read.api.domain.ErrorResponse;
import com.andigital.andservice.read.api.domain.Project;
import com.andigital.andservice.read.api.domain.RestResponse;
import com.andigital.andservice.read.api.domain.SystemProperties;
import com.andigital.andservice.read.api.services.ProjectsService;
import com.andigital.andservice.read.api.services.SystemPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author premsingh 
 * Rest Controller class for Dashboard.
 */
@RestController
@RequestMapping("api/dashboard")
public class DashboardController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SystemPropertiesService systemPropertiesService;

	@Autowired
	ProjectsService projectsService;
	
	//TODO: below is just a sample endpoint to verify other boilerplate configs like mockito among others. to be removed in later sprints.
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		logger.debug("Inside test method {}",new Date());
		return "Rest Service is up and running for DashBoard!!";
	}

	/**
	 * Rest API to get Last System Updated Date
	 */
	@RequestMapping(value = "/systemProperties", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RestResponse> systemLastUpdatedDate() throws ANDRestServiceException {
		SystemProperties systemProperties = null;
		try {
			List<SystemProperties> systemPropertiesList = systemPropertiesService.getSystemProperties();
			if(systemPropertiesList ==null || systemPropertiesList.size() ==0){
				// Error message.. no properties available
				RestResponse restResponse = new RestResponse(false, null,"No System Properties are available",001);
				return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);
			}else{
				systemProperties = systemPropertiesList.get(0);
				if(systemProperties ==null){
					// Error message.. no properties available
					RestResponse restResponse = new RestResponse(false, null,"No System Properties are available",001);
					return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			logger.error("Error in systemLastUpdatedDate {}", e);
			throw new ANDRestServiceException("Error in getting System Properties");
		}

		RestResponse restResponse = new RestResponse(true, systemProperties,null,null);
		return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Project projectsList() throws Exception {
		return projectsService.getProjects().get(0);
	}

	@ExceptionHandler(ANDRestServiceException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

}
