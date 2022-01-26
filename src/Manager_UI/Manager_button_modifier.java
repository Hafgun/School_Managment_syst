/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Window.InscriptionUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hp
 */
public class Manager_button_modifier implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        InscriptionUI screen=new InscriptionUI();
        screen.getBtn_Enregistrer().setEnabled(true);
        screen.getBtn_Modifier().setEnabled(false);
    }
    
}
