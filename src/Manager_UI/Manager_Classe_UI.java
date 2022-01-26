/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Classes;
import Window.ClasseUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Alain Fleury
 */
public class Manager_Classe_UI implements ActionListener{

    private ClasseUI win=null;
    public Manager_Classe_UI(ClasseUI el){
      win=el;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e!=null){
        Classes cl=new Classes(-1,win.getClas().getText());
         cl.enregistrer_Classes();
         JOptionPane.showMessageDialog(null, cl.getInfo());
    
         
       }
    }
    
}
