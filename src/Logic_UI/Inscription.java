/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Alain Fleury
 */
public class Inscription {
   
    private int inscrID;
    private Etudiant etudID;
    private Departement departId;
    private String annee_acad,info;

    public Inscription(int inscrID, Etudiant etudID, Departement departId, String année_acad) {
        this.inscrID = inscrID;
        this.departId = departId;
        this.etudID = etudID;
        this.annee_acad = année_acad;
    }

    
    
  public static Inscription[][] charger_Inscr_Tableau(){
      List<Inscription> el=null;
      Departement dep=null;
      Etudiant etud=null;
      /*ResultSet result=db_Mysql.interrogerBD("select inscrID,etudID,departID,annee_acad from inscription order by etudID");*/
       ResultSet result=db_Mysql.interrogerBD("select * from inscription order by etudID");       
    
      if(result!=null)
      {   el=new ArrayList<Inscription>();
          try {
              while(result.next()){
                  //eviter le gaspillage de la memoire
                  //on va réutiliser l'object precedent
                if(dep==null || etud==null){
                    dep=Departement.get_Dep_A_Parti_ID(result.getInt("departID"));
                    etud=Etudiant.get_Etud_A_Parti_ID(result.getInt("etudID"));
                }
                else  if(dep.getDepartID()!=result.getInt("departID") || etud.getEtudID()!=result.getInt("etudID")){
                        dep=Departement.get_Dep_A_Parti_ID(result.getInt("departID"));
                        etud=Etudiant.get_Etud_A_Parti_ID(result.getInt("etudID"));
                }
                
                 el.add(new Inscription(result.getInt("inscrID"),etud,dep,result.getString("annee_acad")));
                
                  
              }
          } catch (SQLException ex) {
              Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
          }
               
          }
      
      Inscription [][]data=null;
      
      if(el!=null &&el.size()>0){
      
          data=new Inscription[el.size()][7];
          int  j=0;
          for(Inscription d:el){
             
              for(int i=0;i<7;i++)
                  data[j][i]=d;
              j++;
          
          }
          
      }
      
      
      return data;
  }  
    
    /*
    
  public String toString(){
        
      if(nom==null||nom.trim().equalsIgnoreCase(""))
          return "Select les départements";
      return nom;    
  }
    public Inscription(){}

    public Faculte getFaculID() {
        return faculID;
    }
    
    
    public static void Loading_Departemnt(JComboBox dest,int facID){
    
        dest.removeAllItems();
        dest.addItem(new Inscription());
        
        ResultSet result=db_Mysql.interrogerBD("select * from departement where faculID="+facID);
         //
        // System.out.println("select * from departement where faculID="+facID);
        if(result!=null)
        try {
            
            while(result.next()){
                   dest.addItem(new Inscription(result.getInt("departID"),result.getString("nom")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/

    public int getInscrID() {
        return inscrID;
    }

    public String getAnnée_acad() {
        return annee_acad;
    }

    public Departement getDepartId() {
        return departId;
    }

    public Etudiant getEtudID() {
        return etudID;
    }
    
    

    public Inscription(int inscrID, String année_acad) {
        this.inscrID = inscrID;
        this.annee_acad = année_acad;
    }

    public Inscription(Etudiant etudID, Departement departId, String année_acad) {
        this.departId = departId;
        this.etudID = etudID;
        this.annee_acad = année_acad;
    }
 public String getInfo() {
        return info;
    }  
  public void enregistrer_Inscription(){
     
      if(db_Mysql.updateBD("insert into inscription(etudID,departID,annee_acad) values('"+this.etudID.getEtudID()+"','"+this.departId.getDepartID()+"','"+this.annee_acad+"')")>0)
          this.info="Felicitation, l'operation effectuée avec succes";
      else 
          this.info="Désolé, l'echec de l'operation!!";
  }
  public void Modifier_inscription()
  {
     
  }
}
