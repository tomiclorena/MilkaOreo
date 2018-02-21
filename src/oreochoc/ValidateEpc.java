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
public class ValidateEpc {
    private final String headerValueBin = "00110000";
        
    public boolean validate(String header, String filter, String partition){
        return validateHeaderValue(header) && validateFilterValue(filter) && validatePartitionValue(partition);
    }
    
    private boolean validateHeaderValue(String epc){
        return epc.equals(headerValueBin);
    }
    
    private boolean validateFilterValue(String epc){
        return (epc.matches(".*[0-7].*"));
    }
    
    private boolean validatePartitionValue(String epc){
        return (epc.matches(".*[0-6].*"));
    }
    
    public boolean companyPrefixItemRefLen(String epc){
        return (epc.substring(4,17).length() == 13);
    }
    
    public boolean validateCompanyPrefix(int companyPrefixBits){
        return (companyPrefixBits >= 20 && companyPrefixBits <= 40);
    }
    
    public boolean validateItemReference(int itemReferenceBits){
        return (itemReferenceBits >= 4 && itemReferenceBits <= 24);
    }
    
    public boolean isHexNumber(String epc){
        return epc.matches("^[0-9a-fA-F]+$");
    }
    
}
