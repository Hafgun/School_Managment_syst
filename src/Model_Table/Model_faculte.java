/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Table;

import Logic_UI.Faculte;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class Model_faculte extends AbstractTableModel{

    private String[] titles=new String []{"ID_Faculte","nom","code"};
    private Faculte data [][]=null;
     public String getColumnName(int col) {
         return titles[col];
    }
     public Model_faculte(Faculte [][] el)
     {
         data=el;
     }
    @Override
    public int getRowCount() {
      if(data!=null)
          return data.length;
      else
          return -1;
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(titles!=null)
            return titles.length;
        else
            return -1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(data!=null)
    {
        if(columnIndex==0 && rowIndex>=0)
            return new Integer(data [rowIndex][columnIndex].getFaculID());
        else if(columnIndex==1 && rowIndex>=0)
            return data [rowIndex][columnIndex].getNom();
        else if(columnIndex==2 && rowIndex>=0)
            return data [rowIndex][columnIndex].getCode();
    }
    return null;
}
}