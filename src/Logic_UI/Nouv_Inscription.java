/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;

import Window.InscriptionUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Nouv_Inscription {
    private int Id_inscr;
    private Faculte faculte;
    private Departement departement;
    private Etudiant etudiant;
    private Classes classe;
    private String info;
    private Annee_Academique id_annee_academique;
    public Nouv_Inscription(){}

    public Nouv_Inscription(Etudiant etud,Faculte fac,Departement dep,Classes cl,Annee_Academique an_ac)
    {
        this.faculte=fac;
        this.departement=dep;
        this.etudiant=etud;
        this.classe=cl;
        this.id_annee_academique=an_ac;
    }
    public Nouv_Inscription(int idInscr,Faculte fac,Departement dep,Classes cl,Etudiant etud,Annee_Academique an_ac)
    {
        this.Id_inscr=idInscr;
        this.faculte=fac;
        this.departement=dep;
        this.etudiant=etud;
        this.classe=cl;
        this.id_annee_academique=an_ac;
    }
    public void verification()
    {
         if(this.faculte==null||this.faculte.getNom().trim().equalsIgnoreCase("") || this.departement==null || 
                this.departement.getNom().trim().equalsIgnoreCase("") ||this.classe==null || this.classe.getNom().equalsIgnoreCase("")
                ||this.etudiant==null || this.etudiant.getNom().equalsIgnoreCase("")
                || this.id_annee_academique==null ||this.id_annee_academique.getAn_ac().equalsIgnoreCase(""))
         JOptionPane.showMessageDialog(null, "Choisissez");
         return ;
      
    }
    
    public void Enregistre_Inscription()
    {
        if(this.faculte.getFaculID() <= 0){
             
            this.info="Désolé, il faut selectionner la faculté!!!";
            return;
        }
        
         if(this.departement.getDepartID() <= 0){
             
            this.info="Désolé, il faut selectionner le département!!!";
            return;
        }
        if(this.classe.getClasseId() <= 0){
             
            this.info="Désolé, il faut selectionner la classe!!!";
            return;
        }
      
        if(this.id_annee_academique.getan_acID() <= 0){
             
            this.info="Désolé, il faut selectionner l'annee academique!!!";
            return;
        }
        if(this.etudiant.getEtudID() <= 0){
             
            this.info="Désolé, il faut selectionner l'étudiant!!!";
            return;
        }
        if(db_Mysql.updateBD("insert into inscription(faculID,etudID,an_acID,classeID,departID) values("
                   +this.getFaculte().getFaculID()+","+this.getEtudiant().getEtudID()+","+this.getAnnee_academique().getan_acID()+","
                   +this.getClasse().getClasseId()+",'"+this.getDepartement().getDepartID()+"')")>0)
           {
            JOptionPane.showMessageDialog(null, "Enregistrement reussi");
            System.out.println("l'index est"+this.getAnnee_academique().getan_acID());
           }
        else
            JOptionPane.showMessageDialog(null, "Erreur");
      
    }
    public void Modifier_inscription()
    {
        
        if(db_Mysql.updateBD("update inscription set faculID="+this.faculte.getFaculID()+",classeID="+this.classe.getClasseId()+","
                + "departID="+this.departement.getDepartID()+",etudID="+this.etudiant.getEtudID()+",an_acID='"+this.id_annee_academique.getan_acID()+"' where inscrID="+this.Id_inscr)>0)
            JOptionPane.showMessageDialog(null, "Inscription modifier avec succes");
        else
            JOptionPane.showMessageDialog(null,"Erreur de modification");
    }       
    public static Nouv_Inscription [][] Tableau_Inscription()
    {
        List<Nouv_Inscription> elements=null;
        Faculte fac;
        Departement depart;
        Classes cl;
        Etudiant etud;
        Annee_Academique an;
        ResultSet result=db_Mysql.interrogerBD("select * from inscription");
        if(result!=null)
        {
            elements=new ArrayList<>();
            try {
                while(result.next())
                {
                    fac=Faculte.get_Fac_A_Parti_ID(result.getInt("faculID"));
                    depart=Departement.get_Dep_A_Parti_ID(result.getInt("departID"));
                    cl=Classes.get_Class_A_Parti_ID(result.getInt("classeID"));
                    etud=Etudiant.get_Etud_A_Parti_ID(result.getInt("etudID"));
                    an=Annee_Academique.get_A_parti_ID(result.getInt("an_acID"));
                    elements.add(new Nouv_Inscription(result.getInt("inscrID"), fac, depart, cl, etud,an));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Nouv_Inscription.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        Nouv_Inscription [][] data=null;
       /* if(elements!=null && elements.size()>0)
        {
            data=new Nouv_Inscription[elements.size()][7];
            int k=0;
            for(Nouv_Inscription insc:elements)
                for(int i=0;i<7;i++)
                    data [k][i]=insc;
            k++;           
        }*/
        if(elements!=null && elements.size()>0)
                data=new Nouv_Inscription[elements.size()][6];
            int j=0;
            for(Nouv_Inscription c:elements)
            {
                for(int i=0;i<6;i++)
                    data [j][i]=c;
                j++;
            }
        return data;
    }
    public String toString(){
        return this.Id_inscr+"";
    }
    public int getId_inscr() {
        return Id_inscr;
    }
    public Faculte getFaculte() {
        return faculte;
    }
    public Departement getDepartement() {
        return departement;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public Classes getClasse() {
        return classe;
    }
    public Annee_Academique getAnnee_academique() {
        return id_annee_academique;
    }

    public String getInfo() {
        return info;
    }
    
}
