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
public class ProductList {
    private String company;
    private String product;
    private String serialNumber;
       
    public ProductList(String company, String product, String serialNumber) {
        this.company = company;
        this.product = product;
        this.serialNumber = serialNumber;
    }
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
 
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
