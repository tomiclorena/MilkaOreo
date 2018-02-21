/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oreochoc;

/**
 *
 * @author lorena
 */
public class OreoLine {
    private String company, itemReference, companyName, itemName;

    public OreoLine(String company, String companyName, String itemReference, String itemName) {
        this.company = company;
        this.itemReference = itemReference;
        this.companyName = companyName;
        this.itemName = itemName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getItemReference() {
        return itemReference;
    }

    public void setItemReference(String itemReference) {
        this.itemReference = itemReference;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
}
