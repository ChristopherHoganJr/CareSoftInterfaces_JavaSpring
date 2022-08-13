package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
//... imports class definition...

	// Inside class:
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();

	// TO DO: Implement a constructor that takes an ID and a role
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
	}
	// TO DO: Implement HIPAACompliantUser!
	// TO DO: Implement HIPAACompliantAdmin!

	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
				this.id, notes);
		securityIncidents.add(report);
	}

	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id,
				"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}

	@Override
	public boolean assignPin(int pin) {
		// turn pin into string
		String p = Integer.toString(pin);
		// check length against 6
		if (p.length() >= 6) {
			// return true
			return true;
		}
		// return false
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// if ID matches ID
		if (this.getId() == confirmedAuthID) {
			// return true
			return true;
		} else {
			// create incident report
			authIncident();
			// return false
			return false;
		}
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		ArrayList<String> allReports = this.getSecurityIncidents();
		return allReports;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

	// TO DO: Setters & Getters

}
