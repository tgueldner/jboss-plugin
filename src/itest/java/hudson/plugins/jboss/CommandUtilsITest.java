/*
 * Created on 10.03.2016
 *
 * Copyright (c) 1999 - 2016 T-Systems Multimedia Solutions GmbH 
 * Riesaer Str. 5, D-01129 Dresden, Germany 
 * All rights reserved.
 */
package hudson.plugins.jboss;

import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.StreamBuildListener;
import hudson.plugins.jboss.JBossBuilder.ServerBean;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * @author Thomas Gueldner
 *
 * Integration test of {@link CommandsUtils}
 *
 */
public class CommandUtilsITest {
	
	private Launcher launcher;
	private JBossBuilder.ServerBean server;
	private BuildListener listener;
	
	private ByteArrayOutputStream logger;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		logger = new ByteArrayOutputStream();
		listener = new StreamBuildListener(logger);
		launcher = new Launcher.LocalLauncher(listener);
		server = new ServerBean("default", "C:/dev/ewai/jboss-6.1.0.Final", 1099, null, 30, 0);
	}
	
	
	@Test
	public void testStop() {
		if( ! CommandsUtils.stop(server, launcher, listener)) {
			// stop command contains errors
			Assert.fail(logger.toString());
		}
	}

}
