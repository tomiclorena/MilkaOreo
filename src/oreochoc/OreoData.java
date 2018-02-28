/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oreochoc;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author lorena
 */
public class OreoData {
    private final ArrayList<OreoLine> oreoDataArray;
    
    public OreoData() {
        oreoDataArray = new ArrayList<>();
    }
  
    public ArrayList<OreoLine> getOreoArray(){
        return oreoDataArray;
    }
    
    public OreoLine getLineNumber(int i){
        return oreoDataArray.get(i);
    }
    
    public int getNumberOfRecords(){
        return oreoDataArray.size();
    }
    
    void importFile(String filePath, String delimiter) {
        try {
            Scanner scanner = new Scanner(new FileReader(filePath));
            String record;
            OreoLine oreoLine;
            int i = 0;
            while(scanner.hasNextLine()){
                record = scanner.nextLine();
                String[] result = record.split(delimiter);
                
                if(i != 0){
                    oreoLine = new OreoLine(result[0], result[1], result[2], result[3]);
                    oreoDataArray.add(oreoLine);
                }
                i++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
