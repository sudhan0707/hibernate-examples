package org.examples.integration.junit.dao;

import org.examples.integration.junit.base.AbstractTestCase;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AppStartupTest extends AbstractTestCase{

	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void should_load_application_context() {
		assertNotNull(applicationContext);
	}
}
