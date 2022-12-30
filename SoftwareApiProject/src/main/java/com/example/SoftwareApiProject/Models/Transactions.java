package com.example.SoftwareApiProject.Models;

public class Transactions {
    private Services service;
    private String user;
    //if user want to refund a transaction -> refund = true
   //if admin accept refund -> refunded = true
    //if true true -> refund accepted
    //if true false -> refund rejected
    private boolean refund = false;
    private boolean refunded = false;
    private boolean checked = false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Transactions(Services service) {
        this.service = service;
    }

    public Transactions() {

    }

    public Transactions(Services service, String user) {
        this.service = service;
        this.user = user;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }
}