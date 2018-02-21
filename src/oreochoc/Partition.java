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
public enum Partition {
    SIX(20, 24), FIVE(24, 20), FOUR(27, 17), THREE(30, 14), 
    TWO(34, 10), ONE(37, 7), ZERO(40, 4);

    private final int companyPrefixBits;
    private final int itemReferenceBits;

    private Partition(int companyPrefixBits, int itemReferenceBits) {
        this.companyPrefixBits = companyPrefixBits;
        this.itemReferenceBits = itemReferenceBits;
    }
    
    public int getItemReferenceBits() {
        return itemReferenceBits;
    }
    
    public int getCompanyPrefixLength() {
        return ordinal() + 6;
    }            
  
    public int getCompanyPrefixBits() {
        return companyPrefixBits;
    }
    
    public static Partition getByPartitionValue(int partitionValue) {
        return values()[6 - partitionValue];
    }            
}