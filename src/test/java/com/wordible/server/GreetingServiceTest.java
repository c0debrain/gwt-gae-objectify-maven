package com.wordible.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.inject.Guice;

public class GreetingServiceTest {

	private GreetingServiceImpl impl;

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig().setStoreDelayMs(5445));

	@Before
	public void setUp() {
		helper.setUp();
		impl = Guice.createInjector(
				new GuiceConfig.MotompaiaModule()).getInstance(
				GreetingServiceImpl.class);
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void testTaskGetsScheduled1() throws InterruptedException {
		impl.greetServer("cat");
		impl.greetServer("zzz");
		impl.greetServer("XeeeX");
		System.out.println(impl.getCount());
		System.out.println(impl.getCount());System.out.println(impl.getCount());
		System.out.println(impl.getCount());System.out.println(impl.getCount());System.out.println(impl.getCount());System.out.println(impl.getCount());
		System.out.println(impl.getCount());System.out.println(impl.getCount());System.out.println(impl.getCount());System.out.println(impl.getCount());
	}
}
