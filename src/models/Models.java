/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import views.Views;
/**
 *
 * @author HP
 * 
 */
public class Models {
    private String nombre = "";
    private String email = "";
    private String path = "C:\\Users\\HP\\Documents\\tic41\\DAII\\archivos\\datos.csv";
    boolean bandera = true;
    
    Views viewCvs;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
   
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                    String [] campos = row.split(",");
                    nombre = campos[0];
                    email = campos[1]; 
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewCvs,"No se ecncuentra el documento" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewCvs,"Error en I/O operación" + ex.getMessage());
        }
    }
    
    public void writeFile(){
        try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        ArrayList<String> nuevo = new ArrayList<>();
                        nuevo.add(nombre);
                        nuevo.add(email);
                        printWriter.print(nombre + "," + email);
                        printWriter.close();
                        JOptionPane.showMessageDialog(viewCvs,"Se modificó ");
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewCvs,"Error en I/O operación" + ex.getMessage());
                }
            }
    }

