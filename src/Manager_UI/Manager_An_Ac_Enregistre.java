/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Annee_Academique;
import Window.Annee_academiqueUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hp
 */
public class Manager_An_Ac_Enregistre implements ActionListener{

    private Annee_academiqueUI screen;
    public Manager_An_Ac_Enregistre(Annee_academiqueUI win)
    {
        this.screen=win;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Annee_Academique an=new Annee_Academique(screen.getAnne_academ().getText());
       an.Enregistre_an_ac();
    }
    
}
