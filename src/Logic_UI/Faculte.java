/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;
//Logic_UI.Faculte

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alain Fleury
 */
public class Faculte {

   private int faculID;
   private String code,info,nom;
      
   public Faculte(){}
   public Faculte(String nom,String code){
       this.nom=nom;
       this.code=code;
   }   
   public Faculte(int facID,String nom,String code){
       this.nom=nom;
       this.code=code;
       this.faculID=facID;
   }
   public String toString(){
     if(nom==null||nom.trim().equalsIgnoreCase(""))
         return "";
     return this.code+"."+this.nom;
   }
   
   public static Faculte get_Fac_A_Parti_ID(int facID){
      
       ResultSet result=db_Mysql.interrogerBD("select * from faculte where faculID="+facID);
       
       if(result!=null)
           try {
               if(result.next())
                   return new Faculte(result.getInt("faculID"),result.getString("nom"),result.getString("code"));
       } catch (SQLException ex) {
           Logger.getLogger(Faculte.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }

   public void enregistrer_Fac_DB(){
     
       if(nom==null||nom.trim().equalsIgnoreCase(""))
       {
         JOptionPane.showMessageDialog(null,"Tapez s'il vous le nom de la faculté","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
       if(!this.nom.matches("[a-zA-Z]+"))
       {
         JOptionPane.showMessageDialog(null,"Tapez un nom en lettres s'il vous plais!","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
       if(code==null||code.trim().equalsIgnoreCase(""))
       {
         JOptionPane.showMessageDialog(null,"Tapez s'il vous le code de la faculté","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
       if(!this.code.matches("[a-zA-Z]{3}"))
       {
         JOptionPane.showMessageDialog(null,"Tapez un code en 3 lettres s'il vous plais!","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
       ResultSet result= db_Mysql.interrogerBD("select * from faculte where nom = '"+this.nom+"' and code= '"+this.code+"'");
       try {
           if (result.next()==true) {
                JOptionPane.showMessageDialog(null,"Faculté déjà enregistrée !","Error",JOptionPane.ERROR_MESSAGE);
           } else {
                if(db_Mysql.updateBD("insert into faculte(nom,code) values('"+this.nom+"','"+this.code+"')")>0)
                   JOptionPane.showMessageDialog(null,"Enregistrement reussi","Information",JOptionPane.INFORMATION_MESSAGE);
               else JOptionPane.showMessageDialog(null, "Operation echoue","Error",JOptionPane.ERROR_MESSAGE);
               
           }
       } catch (SQLException ex) {
           Logger.getLogger(Faculte.class.getName()).log(Level.SEVERE, null, ex);
       }

   }
   
   public void modifier_Fac_DB(int selected){
       if(nom==null||nom.trim().equalsIgnoreCase(""))
       {
         JOptionPane.showMessageDialog(null,"Tapez s'il vous le nom de la faculté","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
       if(!this.nom.matches("[a-zA-Z]+"))
       {
         JOptionPane.showMessageDialog(null,"Tapez un nom en lettres s'il vous plais!","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
       if(code==null||code.trim().equalsIgnoreCase(""))
       {
         JOptionPane.showMessageDialog(null,"Tapez s'il vous le code de la faculté","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
       if(!this.code.matches("[a-zA-Z]{3}"))
       {
         JOptionPane.showMessageDialog(null,"Tapez un code en 3 lettres s'il vous plais!","Error",JOptionPane.WARNING_MESSAGE);
         return;
       }
        if(db_Mysql.updateBD("update faculte set nom='"+this.nom+"' , code='"+this.code+"' where faculID = "+selected)>0)
            JOptionPane.showMessageDialog(null,"Modification reussi","Information",JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(null, "Operation echoue","Error",JOptionPane.ERROR_MESSAGE);
        
   }
       
    public static void Loading_Faculty(javax.swing.JComboBox fac){
        
        ResultSet result=db_Mysql.interrogerBD("select * from faculte");
        
        fac.removeAllItems();
        fac.addItem(new Faculte("select Faculté",""));
        if(result!=null)
        {
            try {
                while(result.next())
                {
                 fac.addItem(new Faculte(result.getInt("faculID"),result.getString("nom"),result.getString("code")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Faculte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static Faculte [][] charger_fac()
    {
        List<Faculte> el_fac=null;
        ResultSet result=db_Mysql.interrogerBD("select * from faculte");

        if(result!=null)
        {
            el_fac=new ArrayList<>();
            try {
                while(result.next())
                {
                    el_fac.add(new Faculte(result.getInt("faculID"),result.getString("nom"),result.getString("code")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Faculte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Faculte data [][]=null;

        if(el_fac!=null && el_fac.size()>0)
            data=new Faculte [el_fac.size()][3];
        int i=0;
        for(Faculte fac:el_fac)
        {
            for(int j=0;j<3;j++)
                data [i][j]=fac;
            i++;
        }
        return data;          
    }
    /*
    Getters and setters
    */
    public String getNom() {
        return nom;
    }

    public int getFaculID() {
        return faculID;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
    public static void main(String[] args) {
//        String text="Kafgsbhhh";
//        String reg="[A-Za-z]+";
//        Pattern patt= Pattern.compile(reg);
//        Matcher mat=patt.matcher(text);
//        boolean result=mat.matches();
//        System.out.println(result);
    }
}
