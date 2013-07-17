package com.wordible.server;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Singleton;
import com.googlecode.objectify.TxnType;
import com.wordible.client.GreetingService;
import com.wordible.server.transaction.Transact;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Singleton
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Transact(TxnType.SUPPORTS)
	public String greetServer(String input) throws IllegalArgumentException {
		System.out.println("helllloo");
		Person p = new Person();
		p.setEmail(input);

		ofy().save().entities(p).now();
		
		return "zzz";
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ofy().load().type(Person.class).count();
	}
}
