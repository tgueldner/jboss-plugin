/*
 * Created on 10.03.2016
 *
 * Copyright (c) 1999 - 2016 T-Systems Multimedia Solutions GmbH 
 * Riesaer Str. 5, D-01129 Dresden, Germany 
 * All rights reserved.
 */
package hudson.plugins.jboss;

import hudson.model.BuildListener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Thomas Güldner
 *
 * Integration tests.
 *
 */
public class JMXUtilsITest {
	
	public static final String HOSTNAME = "localhost";
	public static final int JNDI_PORT = 1099;
	
	@Mock
	BuildListener buildListener;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	 
	
	@Test
	public void testGetMBeanServer() {
		Assert.assertTrue("server down?", JMXUtils.checkServerStatus(HOSTNAME, JNDI_PORT, buildListener, 30, false));
	}
}
