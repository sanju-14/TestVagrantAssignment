package com.rcb.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.rcb.constants.Iconstant;
import com.rcb.exceptions.CustomizeException;
import com.rcb.teamdetail.TeamList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FrameworkUtils {

	JSONArray playerList;
	JSONObject jsonObject;

	public JSONArray getPlayerList() {

		JSONParser parser = new JSONParser();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(Iconstant.JSONFILEPATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Object object = null;
		try {
			object = parser.parse(fileReader);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		jsonObject = (JSONObject) object;

		playerList = (JSONArray) Objects.requireNonNull(jsonObject).get(TeamList.PLAYER.property);

		return playerList;

	}

	/**
	 * To check the team size
	 * <p>
	 * September 24, 2022
	 *
	 * @author Sanjay Kumar Gond
	 */
	public void checkTeamSize() {

		if (getPlayerList().size() > 11) {
			throw new CustomizeException(
					"Your Team Size is more than 11 Players so Please provide correct team size of 11 Player");

		} else if (getPlayerList().size() < 11) {
			throw new CustomizeException(
					"Your Team Size is less than 11 Players so Please provide correct team size of 11 Player");
		}

	}

	/**
	 * Get the country count from the json array
	 * <p>
	 * September 24, 2022
	 *
	 * @param country get the country from the test class
	 * @return count which give the total country count
	 * @author Sanjay Kumar Gond
	 */
	public int getCountryCount(String country) {
		checkTeamSize();
		int count = 0;
		
		for (Object list : playerList) {
			
			jsonObject = (JSONObject) list;
			String countryName = (String) jsonObject.get(TeamList.COUNTRY.property);

			if (!countryName.equals(country)) {
				count++;
			}

		}		
		return count;
	}

	/**
	 * Get the role count from the json array
	 * <p>
	 * September 24, 2022
	 *
	 * @param role get the role in the team from the test class
	 * @return count which give the total count for particular role
	 * @author Sanjay Kumar Gond
	 */
	public int getRoleCount(String role) {
		checkTeamSize();
		int count = 0;
		for (Object list : playerList) {
			jsonObject = (JSONObject) list;
			String roleName = (String) jsonObject.get(TeamList.ROLE.property);

			if (roleName.equals(role)) {
				count++;
			}

		}
		return count;
	}

}
