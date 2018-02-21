/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oreochoc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lorena
 */
public class DecodeEpc {
    private final static Integer BIN = 2;
    private final static Integer HEX = 16;
    private final List<ProductList> productList = new ArrayList<>();  
    ValidateEpc validateEPC = new ValidateEpc();
    
    public List<ProductList> getProductList() {
        return productList;
    }

    private static String addZeros(String s, int n) {
        return s.length() >= n ? s : new String(new char[n - s.length()]).replace('\0', '0') + s;
    }
    
    private static String hexToBinary(String hex) {
        return new BigInteger(hex, HEX).toString(BIN);
    }
    
    private static Long binaryToLong(String substring) {
        return Long.parseLong(substring, BIN);
    }

    private Integer binaryToInt(String partitionValueBinary) {
        return Integer.parseInt(partitionValueBinary, 2);
    }
    
    void decode(String temp) {
    
        String tempBinary = addZeros(hexToBinary(temp), 96);
        
        //header  
        String header = tempBinary.substring(0, 8);
                      
        //filter
        String filter = (tempBinary.substring(8, 11));
        Integer filterValue = binaryToInt(filter);
        
        String partitionValueBinary = (tempBinary.substring(11,14));
        Integer partitionValue = binaryToInt(partitionValueBinary);
        
        if(validateEPC.validate(String.valueOf(header), String.valueOf(filterValue), String.valueOf(partitionValue)))
        {
            //partition 
            Partition partition = Partition.getByPartitionValue(partitionValue);

            //company prefix and item reference digits (L)
            int companyPrefixLen = partition.getCompanyPrefixLength();
            int itemReferenceLen = 13 - companyPrefixLen;

            //company prefix and item reference bits (M)
            int companyPrefixBits = partition.getCompanyPrefixBits();
            int itemReferenceBits = 44 - companyPrefixBits;

            //company prefix value
            Long companyPrefixValue = binaryToLong(tempBinary.substring(14, 14 + companyPrefixBits));
            
            //Long companyPrefixValue = hexToLong(temp.substring(4, 4 + companyPrefixLen));
            String companyPrefix = addZeros(String.valueOf(companyPrefixValue), companyPrefixLen);

            //item reference value
            Long itemReferenceValue = binaryToLong(tempBinary.substring(14 + companyPrefixBits, 58));
            
            //item reference binary
            String itemReference = addZeros(String.valueOf(itemReferenceValue), itemReferenceLen);
            
            //serial number value
            String serialNumber = String.valueOf(binaryToLong(tempBinary.substring(58)));

            if(validateEPC.validateCompanyPrefix(companyPrefixBits)
                    && validateEPC.validateItemReference(itemReferenceBits)){
                ProductList productListRecord = new ProductList(companyPrefix, itemReference, serialNumber);
                productList.add(productListRecord);
            }
            else{
                Main.counter++;
            }
        }
        else{
            Main.counter++;
        }
    }
} 

