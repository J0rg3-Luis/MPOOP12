/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mpoop12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class MPOOP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    File archivo = new File("archivo.txt");
    System.out.println(archivo.exists());
        try {
            boolean seCreo = archivo.createNewFile();
            System.out.println("se creo = "+seCreo);
            System.out.println(archivo.exists());
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("--------------File Writer----------------");
        
        try {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Escriba el texto para el archivo");
        String texto = br.readLine();
            
        FileWriter fw = new FileWriter("fw.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);
        salida.println(texto);
            for (int i = 0; i < 10; i++) {
                salida.println("linea del for "+ i);
            }
        
        salida.close();
        
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("------------------File Reader--------------");
        
        try {
            FileReader fr = new FileReader("fw.csv");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("El texto del archivo es:");
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("-------------------String Tokenizer--------------");
        Platillo platillo = new Platillo();
        float temp = 0;
        String textoTemp;
        String linea = "Enchiladas,50.44,pollo/crema/queso";
        StringTokenizer tokenizador = new StringTokenizer(linea, ",");
        
        while (tokenizador.hasMoreTokens()) {
            textoTemp = tokenizador.nextToken();
            if(temp==0){
                platillo.setNombre(textoTemp);
            }else if(temp==1){
                platillo.setPrecio(Float.parseFloat(textoTemp));
            }else if(temp==2){
                platillo.setIngredientes(textoTemp);
            }
            System.out.println(textoTemp);
            temp++;
        }
        System.out.println(platillo);
    }
    
}
