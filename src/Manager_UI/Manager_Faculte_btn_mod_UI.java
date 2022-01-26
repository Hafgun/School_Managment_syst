/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

/**
 *
 * @author hp
 */
import Logic_UI.Faculte;
import Window.FaculteUI;
import Model_Table.Model_faculte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Manager_UI.Selection.Model_Table_Selection_Faculte;
import javax.swing.table.DefaultTableModel;

public class Manager_Faculte_btn_mod_UI implements ActionListener{
    
    private FaculteUI win=null;
    
    public Manager_Faculte_btn_mod_UI(FaculteUI scr) {
        this.win=scr;
    }
    //Faculte d=(Faculte)win.getTable_fac().getValueAt(win.getTable_fac().getSelectedRow(),0);
   
    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println("Que dois-je faire????");
       //int d=(int)win.getTable_fac().getValueAt(win.getTable_fac().getSelectedRow(), 2) ;
       Faculte d=(Faculte)win.getTable_fac().getValueAt(win.getTable_fac().getSelectedRow(),2);
       Faculte el=new Faculte(win.getTap_nom().getText(),win.getTap_code().getText());
       el.modifier_Fac_DB(d.getFaculID());
       
       //this.win.getTable_fac().setModel(new Model_faculte(Faculte.charger_fac()));
       this.win.getTable_fac().setModel(new DefaultTableModel());
       
       
        //this.win.setContentPane(new FaculteUI().getContentPane());
        //this.win.revalidate();
    }
    
}
