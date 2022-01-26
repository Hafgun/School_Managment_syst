/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alain Fleury
 */
public class Etudiant {

   private int etudID;
   private String nom,prenom,matricule,tel,mail,info;
   private Annee_Academique an;
   
   public Etudiant(String nom,String prenom,String matricule,String tel,String mail,Annee_Academique id_an){
       this.nom=nom;
       this.prenom=prenom;
       this.matricule=matricule;
       this.tel=tel;
       this.mail=mail;
       this.an=id_an;
   }

    public Etudiant(int etudID, String nom, String prenom, String matricule, String tel,String mail,Annee_Academique id_an) {
        this.etudID = etudID;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.tel = tel;
        this.mail=mail;
        this.an=id_an;
    }
   

    public Etudiant(JTextField nomArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   public void enregistrer_Etud_DB(){
     
       if(nom==null||nom.trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous plait le nom de l'étudiant";
         return;
       }
       if(prenom==null||prenom.trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous plait le prenom de l'étudiant";
         return;
       }
       if(matricule==null||matricule.trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous plait le N°matricule de l'étudiant";
         return;
       }
       if(tel==null||tel.trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous plait le N° de Téléphone de l'étudiant";
         return;
       }
       if(getMail()==null||getMail().trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous plait votre adresse e-mail";
         return;
       }
       if(db_Mysql.updateBD("insert into etudiant(nom,prenom,matricule,tel,mail,an_acID) values('"+this.nom+"','"+this.prenom+"','"+this.matricule+"','"+this.tel+"','"+this.mail+"',"+this.an.getan_acID()+")")>0)
           JOptionPane.showMessageDialog(null,"Félicition,enregistrement a reussi" );
       else JOptionPane.showMessageDialog(null, "Erreur");
   }
       
    public String toString(){
      if(nom==null||nom.trim().equalsIgnoreCase(""))
          return "select les Etudiants";
      return nom+" "+prenom;    
  }
    public Etudiant(){
    }
    
    public static void loading_etudiant(JComboBox dest,int id_anne){
    
        dest.removeAllItems();
        dest.addItem(new Etudiant());
        
        ResultSet result=db_Mysql.interrogerBD("select * from etudiant where an_acID="+id_anne);
        if(result!=null)
            try {
                while(result.next())
                    dest.addItem(new Etudiant(result.getInt("etudID"),result.getString("nom"),
                            result.getString("prenom"),result.getString("matricule")
                            ,result.getString("tel"),result.getString("mail"),Annee_Academique.get_A_parti_ID(result.getInt("an_acID"))));
                    
                    } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }}
   
    public static Etudiant get_Etud_A_Parti_ID(int etudID){
      
       ResultSet result=db_Mysql.interrogerBD("select * from etudiant where etudID="+etudID);
       
       if(result!=null)
           try {
               if(result.next())
                   return new Etudiant(result.getInt("etudID"),result.getString("nom")
                           ,result.getString("prenom"),result.getString("matricule"),result.getString("tel"),
                           result.getString("mail"),Annee_Academique.get_A_parti_ID(result.getInt("an_acID")));
       } catch (SQLException ex) {
           Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
   
   

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getTel() {
        return tel;
    }

    public String getInfo() {
        return info;
    }

    public int getEtudID() {
        return etudID;
    }
    public String getMail() {
        return mail;
    }
    public Annee_Academique getAn() {
        return an;
    }
   
    
    

    
   
   
   
   
   
}
