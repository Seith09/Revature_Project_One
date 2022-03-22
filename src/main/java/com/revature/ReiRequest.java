package com.revature;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReiRequest {

    @Id
    private int empId;
    private int amount;
    private String details;

    public ReiRequest(){}

    public ReiRequest(int empId, int amount, String details) {
        this.empId = empId;
        this.amount = amount;
        this.details = details;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
