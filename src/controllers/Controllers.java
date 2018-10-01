/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.Views;
import models.Models;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class Controllers {
    Views viewCvs;
    Models modelCvs;
    ActionListener ac = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCvs.jb_limpiar)
                    limpiar();
            else if(e.getSource() == viewCvs.jb_guardar){
                guardar();
            }
        }
    };
    public Controllers(Views viewCvs, Models modelCvs) {
        this.viewCvs = viewCvs;
        this.modelCvs = modelCvs;
        this.viewCvs.jb_guardar.addActionListener(ac);
        this.viewCvs.jb_limpiar.addActionListener(ac);
        initComponents();
    }
    
    public void limpiar(){
        viewCvs.jtf_nombre.setText("");
        viewCvs.jtf_email.setText("");
    }
    
    public void guardar(){
        modelCvs.setNombre(viewCvs.jtf_nombre.getText());
        modelCvs.setEmail(viewCvs.jtf_email.getText());
        modelCvs.writeFile();
    }
    
    private void initComponents(){
        viewCvs.setVisible(true);
        modelCvs.readFile();
        viewCvs.jtf_nombre.setText(modelCvs.getNombre());
        viewCvs.jtf_email.setText(modelCvs.getEmail());
        
    }
    
}
