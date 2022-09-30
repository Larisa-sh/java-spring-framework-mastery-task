package com.mastery.java.task.dto;

public enum JobTitle {
    RING_KEEPER("Ring keeper"),
    RING_DESTROYER("Ring destroyer"),
    WIZARD("Wizard");

    private final String jobTitle;

    JobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
