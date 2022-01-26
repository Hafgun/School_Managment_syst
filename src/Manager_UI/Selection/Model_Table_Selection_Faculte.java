/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI.Selection;

import Logic_UI.Faculte;
import Window.FaculteUI;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hp
 */
public class Model_Table_Selection_Faculte implements ListSelectionListener{

    FaculteUI screen=null;
    public Model_Table_Selection_Faculte(FaculteUI fac_screen)
    {
     this.screen=fac_screen;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Faculte d=(Faculte)screen.getTable_fac().getValueAt(screen.getTable_fac().getSelectedRow(),2);
       
       FaculteUI.FacID=d;
       screen.getBt_enr().setEnabled(false);
       screen.getBt_mod().setEnabled(true);
       if(d!=null){
           screen.getTap_nom().setText(d.getNom());
           screen.getTap_code().setText(d.getCode());
       }
       
       System.out.println("Data selectionnée:"+d.getFaculID());

    }
    
}
