/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI.Selection;

import Logic_UI.Departement;
import Logic_UI.Nouv_Inscription;
import Model_Table.Model_Nouv_Inscription;
import Window.InscriptionUI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hp
 */
public class Model_table_selection_Inscription implements ListSelectionListener{

    InscriptionUI screen=null;
    public Model_table_selection_Inscription(InscriptionUI wind)
    {
        this.screen=wind;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Nouv_Inscription d=(Nouv_Inscription)screen.getEtudInscTab().getValueAt(screen.getEtudInscTab().getSelectedRow(),7);
       /*----------*/
       /*St c=(Faculte)win.getTab_Dep().getValueAt(win.getTab_Dep().getSelectedRow(),1);*/
       
       
       /*------------*/
       InscriptionUI.inscrID=d;
       screen.getBtn_Enregistrer().setEnabled(false);
       screen.getBtn_Modifier().setEnabled(true);
       if(d!=null)
           //win.getNom_dep().setText(d.getNom());
           screen.getFac().setEditable(true);
           
       System.out.println("Data selectionnée:"+d);

    }
    
}
