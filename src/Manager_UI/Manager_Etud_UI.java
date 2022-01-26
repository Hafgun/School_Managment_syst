/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Annee_Academique;
import Logic_UI.Etudiant;
import Window.Etudiants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alain Fleury
 */
public class Manager_Etud_UI  implements ActionListener{

    private Etudiants win=null;
    private Annee_Academique ann=null;
    
    public Manager_Etud_UI(Etudiants el){
        this.win=el;
    }
    
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       System.out.println("Que dois-je faire????");
        ann=(Annee_Academique)win.getCombo_anne().getSelectedItem();
       
       Etudiant el=new Etudiant(win.getNom_etud().getText(),win.getPrenom_etud().getText(),win.getMatr_etud().getText(),win.getTel_etud().getText(),win.getMail().getText(),ann);
       el.enregistrer_Etud_DB();
       System.out.println(el.getInfo());
    }
    
    
}
