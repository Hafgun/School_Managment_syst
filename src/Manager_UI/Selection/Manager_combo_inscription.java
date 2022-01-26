/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI.Selection;

import Logic_UI.Classes;
import Logic_UI.Departement;
import Logic_UI.Etudiant;
import Logic_UI.Faculte;
import Logic_UI.Inscription;
import Logic_UI.Nouv_Inscription;
import Window.InscriptionUI;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hp
 */
public class Manager_combo_inscription implements ListSelectionListener{

    InscriptionUI screen=null;
    public Manager_combo_inscription(InscriptionUI ec)
    {
        this.screen=ec;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
        /*int index_tab=screen.getEtudInscTab().getSelectedRow();
        System.out.println("ligne est :"+index_tab);
        int id_inscr=(Integer)screen.getEtudInscTab().getValueAt(index_tab, 0);
      Faculte fac=(Faculte) screen.getEtudInscTab().getValueAt(index_tab,2);
       Etudiant et=(Etudiant)screen.getEtudInscTab().getValueAt(index_tab,1);
       Departement dep=(Departement)screen.getEtudInscTab().getValueAt(index_tab, 3);
       Classes cl=(Classes)screen.getEtudInscTab().getValueAt(index_tab, 4);
       String an_ac=(String)screen.getEtudInscTab().getValueAt(index_tab, 5);
        Nouv_Inscription index=new Nouv_Inscription(fac, dep, cl, et, an_ac);*/
         if(e==null)
            return;
        Nouv_Inscription index=(Nouv_Inscription) screen.getEtudInscTab().getValueAt(screen.getEtudInscTab().getSelectedRow(),0);

        screen.i=index;
        if(index==null)
            return ;
        screen.getBtn_Enregistrer().setEnabled(false);
        screen.getBtn_Modifier().setEnabled(true);
        
        screen.getFac().setSelectedIndex(screen.get_index_faculte(index.getFaculte()));
        System.out.println("l'index de la faculte:"+screen.get_index_faculte(index.getFaculte()));
        
        screen.getDep().setSelectedIndex(screen.get_index_departement(index.getDepartement()));
        System.out.println("l'index de la departement:"+screen.get_index_departement(index.getDepartement()));
        
        screen.getClas().setSelectedIndex(screen.get_index_cla(index.getClasse()));
        System.out.println("l'index de la classe:"+screen.get_index_cla(index.getClasse()));
        screen.getAc().setSelectedIndex(1);
        System.out.println("l'index de l annee:"+screen.get_index_anne_academique(index.getAnnee_academique()));
        screen.getEtud().setSelectedIndex(screen.get_index_etudiant(index.getEtudiant()));
        System.out.println("l'index de l etudiant:"+screen.get_index_etudiant(index.getEtudiant()));
    }
    
}
