package com.wordible.server;

import javax.inject.Singleton;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.matcher.Matchers;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.googlecode.objectify.ObjectifyService;
import com.wordible.server.transaction.Transact;
import com.wordible.server.transaction.TransactInterceptor;

/**
 * Creates our Guice module
 * 
 * @author Jeff Schnitzer
 */
public class GuiceConfig extends GuiceServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(GuiceConfig.class);

	/** */
	static class MotomapiaServletModule extends ServletModule {
		/*
		 * (non-Javadoc)
		 * 
		 * @see com.google.inject.servlet.ServletModule#configureServlets()
		 */
		@Override
		protected void configureServlets() {
			// Map<String, String> appstatsParams = Maps.newHashMap();
			// appstatsParams.put("logMessage",
			// "Appstats: /admin/appstats/details?time={ID}");
			// appstatsParams.put("calculateRpcCosts", "true");
			// filter("/*").through(AppstatsFilter.class, appstatsParams);
			// serve("/appstats/*").with(AppstatsServlet.class);
			serve("/Wordible/greet").with(GreetingServiceImpl.class);

			filter("/*").through(ObjectifyFilter.class);
		}
	}

	/** Public so it can be used by unit tests */
	public static class MotompaiaModule extends AbstractModule {
		@Override
		protected void configure() {

			// Lets us use @Transact
			bindInterceptor(Matchers.any(),
					Matchers.annotatedWith(Transact.class),
					new TransactInterceptor());

			// External things that don't have Guice annotations
			// bind(AppstatsFilter.class).in(Singleton.class);
			// bind(AppstatsServlet.class).in(Singleton.class);
			bind(ObjectifyFilter.class).in(Singleton.class);
			ObjectifyService.register(Person.class);
		}
	}

	/**
	 * Logs the time required to initialize Guice
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		long time = System.currentTimeMillis();

		super.contextInitialized(servletContextEvent);

		long millis = System.currentTimeMillis() - time;
		logger.info("Guice initialization took " + millis + " millis");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.servlet.GuiceServletContextListener#getInjector()
	 */
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new MotomapiaServletModule(),
				new MotompaiaModule());
	}

}