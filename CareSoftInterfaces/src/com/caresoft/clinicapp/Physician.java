package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...

	// Inside class:
	private ArrayList<String> patientNotes;

	// TO DO: Constructor that takes an ID
	// TO DO: Implement HIPAACompliantUser!

	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	public Physician(Integer id) {
		super(id);
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	@Override
	public boolean assignPin(int pin) {
		// convert pin into string
		String p = Integer.toString(pin);
		// check string length against variable
		if (p.length() == 4) {
			// return true if they match
			return true;
		}
		// else return false
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// if ID matches confirmedAuthID
		if (this.getId() == confirmedAuthID) {
			// return true
			return true;
		}
		// else return false
		return false;
	}

	// TO DO: Setters & Getters

}
