/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_btn_inscription;

import Logic_UI.Annee_Academique;
import Logic_UI.Classes;
import Logic_UI.Departement;
import Logic_UI.Etudiant;
import Logic_UI.Faculte;
import Logic_UI.Nouv_Inscription;
import Manager_UI.Selection.Manager_combo_inscription;
import Model_Table.Model_Nouv_Inscription;
import Window.InscriptionUI;
import static Window.InscriptionUI.i;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hp
 */
public class Manager_btn_modifier implements ActionListener{
    private InscriptionUI screen;
    public Manager_btn_modifier(InscriptionUI win)
    {
        this.screen=win;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Faculte fac=(Faculte) screen.getFac().getSelectedItem();
        Departement dep=(Departement)screen.getDep().getSelectedItem();
        Classes cl=(Classes)screen.getClas().getSelectedItem();
        Etudiant etud=(Etudiant)screen.getEtud().getSelectedItem();
        Annee_Academique an=(Annee_Academique) screen.getAc().getSelectedItem();
        
         Nouv_Inscription insc=new Nouv_Inscription(i.getId_inscr(),fac, dep, cl, etud, an);
        insc.Modifier_inscription();
        screen.getEtudInscTab().setModel(new Model_Nouv_Inscription(Nouv_Inscription.Tableau_Inscription()));
    }
    
}
