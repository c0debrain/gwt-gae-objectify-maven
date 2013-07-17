package com.wordible.server;

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * One human user associated with an email address.
 * 
 * @author Jeff Schnitzer
 */
@Entity
@Cache
public class Person {
	/** */
	public static Key<Person> key(long id) {
		return Key.create(Person.class, id);
	}

	/**
	 * Synthetic id
	 */
	@Id
	Long id;

	/** Pretty, non-normalized version */
	String email;

	/** Date user first logged in */
	@Index
	Date created;

	/** Date user last logged in */
	@Index
	Date lastLogin;

	/**
*/
	/** */
	public void loggedIn() {
		this.lastLogin = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	// public Key<Person> getKey() {
	// return key(id);
	// }
}