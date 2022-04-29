/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nyeregpont;

/**
 *
 * @author JavorLas
 */
public class FizMatrix {
    public static boolean Van_eNyeregpont(double[][] matrix){
        int x,y;
        boolean vanNyeregpont;
        double[] soriMinimumok = new double [100];
        double[] oszlopMaximumok=new double[100];
        double soriMinimumokMaximuma=Double.NEGATIVE_INFINITY;
        double oszlopMaximumokMinimuma=Double.POSITIVE_INFINITY;
        for (int i=0;i<100;i++){
            soriMinimumok[i]=Double.POSITIVE_INFINITY;
            oszlopMaximumok[i]=Double.NEGATIVE_INFINITY;
        }
        
        y=0;    // A mátrix sorain végigfutva meghatározzuk a min-értékeket
        while (matrix[y][0]!=Double.POSITIVE_INFINITY){
            x=0;
            while (matrix[0][x]!=Double.POSITIVE_INFINITY){
                System.out.print(matrix[y][x]+", ");
                if (matrix[y][x]<soriMinimumok[y])
                    soriMinimumok[y]=matrix[y][x];
                x++;
            }
            System.out.println("\t\tSoriMinimum["+y+"]="+soriMinimumok[y]);
            y++;
        }
        soriMinimumok[y]=Double.POSITIVE_INFINITY;
        
        x=0;    // A mátrix oszlopain végigfutva meghatározzuk a max-értékeket
        while (matrix[0][x]!=Double.POSITIVE_INFINITY){
            y=0;
            while (matrix[y][0]!=Double.POSITIVE_INFINITY){
                System.out.print(matrix[y][x]+", ");
                if (matrix[y][x]>oszlopMaximumok[x])
                    oszlopMaximumok[x]=matrix[y][x];
                y++;
            }
            System.out.println("\t\tOszlopMaximum["+x+"]="+oszlopMaximumok[x]);
            x++;
        }
        oszlopMaximumok[x]=Double.POSITIVE_INFINITY;
        
        y=0;
        while (soriMinimumok[y]!=Double.POSITIVE_INFINITY){            
            if (soriMinimumok[y]>soriMinimumokMaximuma)
                soriMinimumokMaximuma=soriMinimumok[y];
            y++;
        }

        x=0;
        while (oszlopMaximumok[x]!=Double.POSITIVE_INFINITY){
            if (oszlopMaximumok[x]<oszlopMaximumokMinimuma)
                oszlopMaximumokMinimuma=oszlopMaximumok[x];
            x++;
        }

        System.out.print("Sori minimumok maximuma: "+soriMinimumokMaximuma+", ");
        System.out.println("oszlopok maximumának minimuma: "+oszlopMaximumokMinimuma);
        vanNyeregpont=false;
        if (soriMinimumokMaximuma==oszlopMaximumokMinimuma){
            System.out.println("A minimumok maximuma egyezik a maximumok minimumával.");
            y=0;    // A mátrix elemein végigfutva keresünk megegyező értékeket
            while (matrix[y][0]!=Double.POSITIVE_INFINITY){
                x=0;
                while (matrix[0][x]!=Double.POSITIVE_INFINITY){
                    // System.out.print(matrix[y][x]+", ");
                    if (matrix[y][x]==soriMinimumokMaximuma)
                        if (matrix[y][x]==soriMinimumok[y] && matrix[y][x]==oszlopMaximumok[x])
                            vanNyeregpont=true;
                    x++;
                }
                y++;
            }                     
        }        
        System.out.println("FizMatrix: "+(vanNyeregpont?"Találtam":"Nem találtam")+" nyeregpontot.");
        return vanNyeregpont;
    }
}
