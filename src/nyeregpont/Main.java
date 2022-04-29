/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nyeregpont;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author JavorLas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] tomb =new double [100][100];
        String str;
        int posX;
        int posY=0;
        try {
            File tombInput=new File ("nyeregpont.txt");
            Scanner in=new Scanner(tombInput);
            System.out.println("File megnyitva.");
            while (in.hasNextLine()){
                str=in.nextLine();
                System.out.println("Feldogozandó sor: "+str);
                String[] str_ = str.split(" ");
                for (posX=0;posX<str_.length;posX++){
//                    System.out.println(Double.parseDouble(str_[posX]));
                    tomb[posY][posX]=Double.parseDouble(str_[posX]);
                }
                tomb[posY][posX]=Double.POSITIVE_INFINITY;
                posY++;
            }
            tomb[posY][0]=Double.POSITIVE_INFINITY;
            in.close();
            System.out.println("File lezárva."); 
        }
        catch (FileNotFoundException e){
            System.out.println("Nem találtam a nyeregpont.txt file-t");
            System.exit(1);
        }
        System.out.println((FizMatrix.Van_eNyeregpont(tomb)?"Van":"Nincs")+" nyeregpont.");
    }
    
}
