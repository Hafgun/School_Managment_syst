/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Table;

import Logic_UI.Nouv_Inscription;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class Model_Nouv_Inscription extends AbstractTableModel {
   
    private String[]titles=new String[]{"InscrID","Etudiant","Faculté","Departement","Classe","Année_Acad"};
    private Nouv_Inscription [][] data=null;
    
    public String getColumnName(int col) {
         return titles[col];
    }
    public Model_Nouv_Inscription(Nouv_Inscription [][] el)
    {
        data=el;
    }
            @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(data!=null)
           return data.length;
       else return -1;
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(titles==null)
            return -1;
        return titles.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      
     if(data!=null)
     {  
      if(columnIndex==0 && rowIndex>=0)
         return (data[rowIndex][columnIndex]);
      else if(columnIndex==1 && rowIndex>=0) 
          return data[rowIndex][columnIndex].getEtudiant();
      else if(columnIndex==2 && rowIndex>=0)
          return data[rowIndex][columnIndex].getDepartement().getFaculID();
      else if(columnIndex==3 && rowIndex>=0)
          return data[rowIndex][columnIndex].getDepartement();
      else if(columnIndex==4 && rowIndex>=0)
          return data[rowIndex][columnIndex].getClasse();
      else if(columnIndex==5 && rowIndex>=0)
          return data[rowIndex][columnIndex].getAnnee_academique();
    }
     return null;
    }
}
