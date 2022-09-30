package com.caresoft.clinicapp;

import com.caresoft.clinicapp.HIPPACompliantUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;



public class Physician extends User implements HIPPACompliantUser {

    public Physician(int id) {
        super(id);
        this.patientNotes = new ArrayList<>();
    }

    public boolean assignPin(int pin ) {
        return (Integer.toString(pin).length() == 4);
    }


public boolean accessAuthorized(Integer confirmAuthId) {
        return Objects.equals(confirmAuthId, this.getId());
}

    private ArrayList<String> patientNotes;


    // Inside class:

    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format("Datetime Submitted: %s\n",date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

}
