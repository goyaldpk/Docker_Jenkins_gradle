/**
 * 
 */
package com.andigital.andservice.read.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.andigital.andservice.read.api.ANDServiceAPIApplicationTests;
import com.andigital.andservice.read.api.domain.SystemProperties;

/**
 * @author premsingh
 * Test class for SystemPropertiesRepository.
 */
@Test(groups="system-properties")
public class SystemPropertiesRepositoryTest extends ANDServiceAPIApplicationTests {

	@Autowired
	private SystemPropertiesRepository systemPropertiesRepository;
	
	private static String updatedDate = new Date().toString();

	@BeforeGroups("system-properties")
	public void setUp() throws Exception {
		SystemProperties sys = new SystemProperties();
		sys.setLast_updated_date(updatedDate);
		// save System Properties, verify has ID value after save
		Assert.assertNull(sys.getId());
		this.systemPropertiesRepository.save(sys);
		Assert.assertNotNull(sys.getId());
	}

	public void testGetSystemLastUpdatedDate() {
		/* Test data retrieval */
		List<SystemProperties> sysList = systemPropertiesRepository.findAll();
		Assert.assertNotNull(sysList);
		Assert.assertNotNull(sysList.get(0).getLast_updated_date());
		Assert.assertEquals(sysList.get(0).getLast_updated_date(), updatedDate);
	}

	@AfterTest
	public void tearDown() throws Exception {
		this.systemPropertiesRepository.deleteAll();
	}

}
