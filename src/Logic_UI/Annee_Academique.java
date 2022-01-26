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
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Annee_Academique {
    private int an_acID;
    private String an_ac;
    public Annee_Academique(String an)
    {
        this.an_ac=an;
    }
    public Annee_Academique(int id,String an)
    {
        this.an_acID=id;
        this.an_ac=an;
    }
     public String toString(){
        return this.an_ac+"";
    }
    public void Enregistre_an_ac()
    {
       if(this.getAn_ac()==null || this.getAn_ac().trim().equalsIgnoreCase(""))
       {
         JOptionPane.showMessageDialog(null,"Tapez l'annee academique");
         return;
       }
       
       if(db_Mysql.updateBD("insert into annee_academique(annee) values('"+this.getAn_ac()+"')")>0)
        JOptionPane.showMessageDialog(null,"Enregistrement reussi");
       else JOptionPane.showMessageDialog(null, "Operation echoue");
   }
    public static void loading_anne_academique(javax.swing.JComboBox dest)
    {
        try {
            ResultSet result=db_Mysql.interrogerBD("select * from annee_academique");
            dest.removeAllItems();
            dest.addItem(new Annee_Academique("select annee"));
            if(result!=null)
                while(result.next())
                {
                    dest.addItem(new Annee_Academique(result.getInt("an_acID"), result.getString("annee")));
                }
        } catch (SQLException ex) {
            Logger.getLogger(Annee_Academique.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Annee_Academique get_A_parti_ID(int id)
    {
         ResultSet result=db_Mysql.interrogerBD("select * from annee_academique where an_acID="+id);
            if(result!=null)
                 try {
                while(result.next())
                {
                    return new Annee_Academique(result.getInt("an_acID"), result.getString("annee"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(Annee_Academique.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
    public int getan_acID() {
        return an_acID;
    }
    public String getAn_ac() {
        return an_ac;
    }
    
}
