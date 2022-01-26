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
import Model_Table.Model_Departement;
import Model_Table.Model_Nouv_Inscription;
import Window.InscriptionUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Manager_btn_enregistre implements ActionListener{
    private InscriptionUI screen;
    
    private Etudiant etudID;
    private Faculte facultID;
    private Departement departID;
    private Classes classID;
    private Annee_Academique ann;
    
    public Manager_btn_enregistre(InscriptionUI win)
    {
        this.screen=win;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       etudID=(Etudiant)screen.getEtud().getSelectedItem(); 
        facultID=(Faculte)screen.getFac().getSelectedItem();
        departID=(Departement)screen.getDep().getSelectedItem();
        classID=(Classes)screen.getClas().getSelectedItem();
        ann=(Annee_Academique) screen.getAc().getSelectedItem();
        
        Nouv_Inscription insc=new Nouv_Inscription(etudID, facultID, departID, classID, ann);
        insc.Enregistre_Inscription();
       
        
        screen.getEtudInscTab().setModel(new Model_Nouv_Inscription(Nouv_Inscription.Tableau_Inscription()));
        // on acualise le tableau
        //this.fen.getTab_Dep().setModel(new Model_Departement(Departement.charger_Depart_Tableau()));
        //this.screen.getEtudInscTab().setModel(new Model_Nouv_Inscription(Nouv_Inscription.Tableau_Inscription()));
        //JOptionPane.showMessageDialog(null, insc.getInfo());
    }
   
}
