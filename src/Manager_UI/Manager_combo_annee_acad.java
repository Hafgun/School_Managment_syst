/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Annee_Academique;
import Logic_UI.Etudiant;
import Window.Annee_academiqueUI;
import Window.InscriptionUI;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author hp
 */
public class Manager_combo_annee_acad implements ItemListener{
    private InscriptionUI screen;
    public Manager_combo_annee_acad(InscriptionUI in)
    {
        this.screen=in;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e==null)
           return;
        Annee_Academique sel=(Annee_Academique) this.screen.getAc().getSelectedItem();
        if(sel==null)
            return;
        Etudiant.loading_etudiant(screen.getEtud(), sel.getan_acID());
    }
    
}
