/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Classes;
import Logic_UI.Departement;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Logic_UI.departement_class;
import Window.Dep_Classes;

/**
 *
 * @author Alain Fleury
 */
public class Manager_Dep_Ev implements ItemListener {

    Dep_Classes win;
    
    public Manager_Dep_Ev(Dep_Classes w){
     this.win=w;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e==null) return;
        
        Departement dep=(Departement)this.win.getDep().getSelectedItem();
        if(dep==null) return;
        //Classes.loading_classes(this.win.getClass_(), dep.getDepartID());
        departement_class depart_cl=new departement_class();
    }
    
    
}



