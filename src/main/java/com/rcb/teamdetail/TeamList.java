package com.rcb.teamdetail;

/**
 * Enums to restrict the users to choose an appropriate field
 *
 * September 24, 2022
 * 
 * @author Sanjay Kumar Gond
 * @version 1.0
 *
 */
public enum TeamList {

	PLAYER("player"), COUNTRY("country"), ROLE("role");

	public final String property;

	TeamList(String property) {

		this.property = property;
	}
}
