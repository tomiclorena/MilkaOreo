/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oreochoc;

import java.io.IOException;
import java.net.URL;

/**
 *
 * @author lorena
 */
public class Main {
    public static int counter = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URL tagsURL = Main.class.getResource("/res/tags.txt");
        String tagsPath = tagsURL.getPath();
        
        Sgtin sgtinValues = new Sgtin();
        sgtinValues.importFile(String.valueOf(tagsPath));
        sgtinValues.decodeEPC();
        System.out.println("Broj krivo formatiranih tagova: " + counter);
        
        System.out.println("Press Enter key to continue...");
        try{
            System.in.read();
        }  
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
