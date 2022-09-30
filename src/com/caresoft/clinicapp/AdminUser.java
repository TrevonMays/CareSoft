package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPPACompliantUser,HIPPACompliantAdmin {

    //... imports class definition...

    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<>();

    public AdminUser(Integer employeeID, String role) {
        super(employeeID);
        this.role = role;
    }

    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return this.securityIncidents;
    }

    public boolean accessAuthorized(Integer confirmedAuthID) {
        authIncident();
        return confirmedAuthID == this.employeeID;
    }

    public boolean assignPin(int pin) {
        return (Integer.toString(pin).length() == 6);
    }

    // TO DO: Setters & Getters
}

