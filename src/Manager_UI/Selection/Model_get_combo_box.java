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
import Logic_UI.Nouv_Inscription;
import Model_Table.Model_Nouv_Inscription;
import Window.InscriptionUI;

/**
 *
 * @author hp
 */
public class Model_get_combo_box {
    
    static InscriptionUI ins=null;
    static Nouv_Inscription i;
    
    public static int get_index_faculte(Faculte fac)
    {
        Faculte fa=null;
        int i=-1;
        if(ins.getFac()!=null)
            for(i=0;i<ins.getFac().getItemCount();i++)
            {
                fa=(Faculte)ins.getFac().getItemAt(i);
                if(fac.getFaculID()==fa.getFaculID())
                    return i;
            }    
        return i;
    }
    public static int get_index_departement(Departement dep)
    {
        Departement depart=null;
        int i=-1;
        if(ins.getDep()!=null)
        {
            for(i=0;i<ins.getDep().getItemCount();i++)
            {
               depart=(Departement)ins.getDep().getItemAt(i);
               if(depart.getDepartID()==dep.getDepartID())
               {
                   i=depart.getDepartID();
                   return i;
               }
            }
        }
        return i;
    }
    public static int get_index_classe(Classes cl)
    {
        Classes classe =null;
        int i=-1;
        if(ins.getClas()!=null)
        {
           for(i=0;i<ins.getClas().getItemCount();i++)
            {
                classe=(Classes)ins.getClas().getItemAt(i);
                if(classe.getClasseId()==cl.getClasseId())
                {
                    i=classe.getClasseId();
                    return i;
                }
               
            }
            
        }
        return i;
    }
    public static int get_index_etudiant(Etudiant et)
    {
        Etudiant etud=null;
        int i=-1;
        if(ins.getFac()!=null)
        {
            for(i=0;i<ins.getFac().getItemCount();i++)
            {
                etud=(Etudiant)ins.getEtud().getItemAt(i);
                if(etud.getEtudID()==et.getEtudID())
                    return i;
            }
        }
        return i;
    }
    public static int get_index_anne_academique(String an_ac)
    {
        String ac=null;
        int i=-1;
        if(ins.getAc()!=null)
        {
            
            for(i=0;i<ins.getAc().getItemCount();i++)
            {
                ac=ins.getAc().getItemAt(i);
                if(ac.equals(an_ac)==true)
                    return i;
            }
        }
        return i;
    }
    Model_Nouv_Inscription tab_insc=(Model_Nouv_Inscription) ins.getEtudInscTab().getModel();
    int index=ins.getEtudInscTab().getSelectedRow();
    
}
