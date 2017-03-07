package com.ota.updates.types;


public class CreditsItem {
    private String devName;
    private String devCredit;

    public void setDevName(String devName){
        this.devName = devName;
    }

    public void setDevCredit(String devCredit) {
        this.devCredit = devCredit;
    }

    public String getDevName() {
        return devName;
    }

    public String getDevCredit() {
        return devCredit;
    }

    public CreditsItem(String devName, String devCredit){
      this.devName = devName;
      this.devCredit = devCredit;
    }
}
