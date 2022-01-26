/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;

import Logic_UI.Classes;
import Logic_UI.Departement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alain Fleury
 */
public class departement_class {
    
    private int depart_clId;
    private Departement depart_Id;
    private Classes classe_Id;
    private String info;
    
    public departement_class() {
        
    }
    
    public departement_class(Departement depart_Id,Classes classe_Id){
        this.depart_Id=depart_Id;
        this.classe_Id=classe_Id;
        
    }

    public departement_class(int depart_clId, Departement depart_Id, Classes classe_Id) {
        this.depart_clId = depart_clId;
        this.depart_Id = depart_Id;
        this.classe_Id = classe_Id;
    }
    
    
    /*public departement_class(int id, Departement dep,Classes class) 
    {
        
    this.depart_clId=id;
    this.depart_Id=dep;
    this.classe_Id=class;
        
    }
    
    
   /* public departement_class(Departement dep,Classes class) {
    this.depart_Id=dep;
    this.classe_Id=class;
  
    }*/
    public void Enregistrer(){
        
        if(this.depart_Id.getDepartID() <= 0){
             
            this.info="Désolé, il faut selectionner le département!!!";
            return;
        }
        
         if(this.classe_Id.getClasseId() <= 0){
             
            this.info="Désolé, il faut selectionner la classe!!!";
            return;
        }        
        ResultSet result= db_Mysql.interrogerBD("select * from departement_classes where departID="+this.depart_Id.getDepartID()+" and classeID ="+this.classe_Id.getClasseId());
        try {
            if(result.next()==true)
            {
                this.info="Désolé la classe existe déjà dans le département";
            }
            else
            {
                if(db_Mysql.updateBD("insert into departement_classes (departID,classeID) values("+this.depart_Id.getDepartID()+","+this.classe_Id.getClasseId()+")")>0)
                {
                    setInfo("insertion reussi");
                }else setInfo("desolé échec");
            }
        } catch (SQLException ex) {
            Logger.getLogger(departement_class.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void verifierClasse_dans_Dep(int depart,int clas)
    {
        ResultSet result=db_Mysql.interrogerBD("select exists(select departID,classeID from departement_classes where departID="+this.depart_Id.getDepartID()+" and classeID ="+this.classe_Id.getClasseId()+")");
       
    }
    public static departement_class get_DepCl_A_Parti_ID(int DepClID){
        try {
            ResultSet result=db_Mysql.interrogerBD("select departID,classeID from departement_classes where departClID="+DepClID);
            int depID=result.getInt("departID");
            int clID=result.getInt("classeID");
            Departement dep=Departement.get_Dep_A_Parti_ID(depID);
            Classes cl=Classes.get_Class_A_Parti_ID(clID);
            
            if(result!=null)
                try {
                    if(result.next())
                        return new departement_class(result.getInt("departClID"),dep,cl);
                } catch (SQLException ex) {
                    Logger.getLogger(departement_class.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (SQLException e) {
            
        }
        return null;
    }
    
  

    public int getDepart_clId() {
        return depart_clId;
    }

    public Departement getDepart_Id() {
        return depart_Id;
    }

    public Classes getClasse_Id() {
        return classe_Id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public  void Main(String args [])
    {
       //verifierClasse_dans_Dep(3,2);
        //System.out.println(a);
    }

    
}
