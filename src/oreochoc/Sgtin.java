/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oreochoc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.*;

/**
 *
 * @author lorena
 */
public class Sgtin {
    private final ArrayList<String> epcArray;
    
    public Sgtin() {
        epcArray = new ArrayList<>();
    }

    public void importFile(String filePath) {
        try {
            ValidateEpc validateEPC = new ValidateEpc();
            Scanner scanner = new Scanner(new FileReader(filePath));
            String record;
            while(scanner.hasNextLine()){
                record = scanner.nextLine();  
                if(validateEPC.companyPrefixItemRefLen(record) && validateEPC.isHexNumber(record)){
                    epcArray.add(record);
                }
                else{
                    Main.counter++;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void decodeEPC(){
        DecodeEpc decodeEPC = new DecodeEpc();
        epcArray.forEach((temp) -> {
            decodeEPC.decode(temp);
        });
        
        OreoData oreoData = new OreoData();
       
        URL dataURL = Main.class.getResource("/res/data.csv");
        String dataPath = dataURL.getPath();
        
        oreoData.importFile(String.valueOf(dataPath), ";");
        List<ProductList> productList = decodeEPC.getProductList(); 
        List<OreoLine> oreoLines = oreoData.getOreoArray();

       
        Set<String> oreoCountSet = new LinkedHashSet<>();
        productList.forEach((product) -> {
            oreoLines.forEach((oreoLine) -> {
                if (product.getCompany() == null ? oreoLine.getCompany() == null : product.getCompany().equals(oreoLine.getCompany())
                        && oreoLine.getItemName().equals("Milka Oreo")){
                        oreoCountSet.add(product.getSerialNumber());
                        System.out.println("Serijski broj Oreo Milke " + oreoCountSet.size() + ": " + product.getSerialNumber());
                }
            });
        });
        System.out.println("Broj Oreo Milki: " + oreoCountSet.size());
    }
}
