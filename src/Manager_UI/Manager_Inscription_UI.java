/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Departement;
import Logic_UI.Etudiant;
import Logic_UI.Faculte;
import Logic_UI.Inscription;
import Logic_UI.departement_class;
import Model_Table.Model_Inscription;
import Window.DepartementUI;
import Window.InscriptionUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Alain Fleury
 */
public class Manager_Inscription_UI implements ActionListener {

     
    private Departement departId;
    private Etudiant etudID;
    private String annee_acad;
    private Window.InscriptionUI fen;
    
    public Manager_Inscription_UI(InscriptionUI el){
        this.fen=el;
 
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
       
        departId=(Departement)fen.getDep().getSelectedItem();
        etudID=(Etudiant)fen.getEtud().getSelectedItem();
       this.annee_acad=(String) fen.getAc().getSelectedItem();
       Inscription insc=new Inscription(etudID,departId,this.annee_acad);
    
        insc.enregistrer_Inscription();
        
        //on actualise le tableau
        this.fen.getEtudInscTab().setModel(new Model_Inscription(Inscription.charger_Inscr_Tableau()));
        JOptionPane.showMessageDialog(null, insc.getInfo());
    


    }
    
    
}
