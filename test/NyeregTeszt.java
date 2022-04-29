/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.pow;
import nyeregpont.FizMatrix;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author JavorLas
 */
public class NyeregTeszt {
    static double[][] tesztMatrix = new double[100][100];

    public NyeregTeszt(){        
    }
    
    @Before
    public void setUp(){
        for (int y=0;y<100;y++)
            for (int x=0;x<100;x++)
                tesztMatrix[y][x]=Double.POSITIVE_INFINITY;
    }
    
    @Test
    public void testFullZero(){
        for (int i=0;i<5;i++)
            for (int j=0;j<5;j++)
                tesztMatrix[i][j]=0.0;
        assertEquals(true,FizMatrix.Van_eNyeregpont(tesztMatrix));
    }
    
    @Test
    public void testAlternatingOnes(){
        for (int i=0;i<5;i++)
            for (int j=0;j<5;j++)
                tesztMatrix[i][j]=pow(-1,i+j);
        assertEquals(false,FizMatrix.Van_eNyeregpont(tesztMatrix));
    }
    
    @Test
    public void testMorra(){
        tesztMatrix[0][0]= 2;
        tesztMatrix[0][1]= -3;
        tesztMatrix[1][0]= -3;
        tesztMatrix[1][1]= 4;
        assertEquals(false,FizMatrix.Van_eNyeregpont(tesztMatrix));
    }
    
    @Test
    public void testBookSample(){
        tesztMatrix[0][0]= -3;
        tesztMatrix[0][1]= -1;
        tesztMatrix[0][2]= 4;
        tesztMatrix[0][3]= 1;
        tesztMatrix[1][0]= 3;
        tesztMatrix[1][1]= -2;
        tesztMatrix[1][2]= 0;
        tesztMatrix[1][3]= 1;
        tesztMatrix[2][0]= 2;
        tesztMatrix[2][1]= -1;
        tesztMatrix[2][2]= 2;
        tesztMatrix[2][3]= 3;
        tesztMatrix[3][0]= 1;
        tesztMatrix[3][1]= -4;
        tesztMatrix[3][2]= -2;
        tesztMatrix[3][3]= 6;     
        assertEquals(true,FizMatrix.Van_eNyeregpont(tesztMatrix));
    }
    
}
