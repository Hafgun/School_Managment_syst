/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

import Logic_UI.Annee_Academique;
import Logic_UI.Classes;
import Logic_UI.Departement;
import Logic_UI.Etudiant;
import Logic_UI.Etudiant;
import Logic_UI.Faculte;
import Logic_UI.Inscription;
import Logic_UI.Nouv_Inscription;
import Logic_UI.db_Mysql;

import Manager_UI.Manager_Ev_DepartCombo1;
import Manager_UI.Manager_Ev_EtudCombo;
import Manager_UI.Manager_Ev_FaculteUI1;
import Manager_UI.Manager_Inscription_UI;
import Manager_UI.Manager_button_modifier;
import Manager_UI.Manager_combo_annee_acad;
import Manager_UI.Selection.Manager_combo_inscription;
import Manager_btn_inscription.Manager_btn_enregistre;
import Manager_btn_inscription.Manager_btn_modifier;
import Model_Table.Model_Inscription;
import Model_Table.Model_Nouv_Inscription;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class InscriptionUI extends javax.swing.JFrame {

    /**
     * Creates new form EtudiantUI
     */
    public static Nouv_Inscription inscrID=null;
    public InscriptionUI() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        Faculte.Loading_Faculty(fac);
        Departement.Loading_Departemnt(dep, -1);
        Classes.loading_classes(clas,-1);
        Etudiant.loading_etudiant(etud,-1);
        Annee_Academique.loading_anne_academique(ac);
        
        fac.addItemListener(new Manager_Ev_FaculteUI1(this));
        dep.addItemListener(new Manager_Ev_DepartCombo1(this));
        ac.addItemListener(new Manager_combo_annee_acad(this));
        btn_Enregistrer.addActionListener(new Manager_btn_enregistre(this));
        btn_Modifier.addActionListener(new Manager_btn_modifier(this));
        btn_Enregistrer.setEnabled(true);
        btn_Modifier.setEnabled(false);
        
        //ac.addItemListener(new Manager_Ev_EtudCombo(this));
        //btn_Enregistrer.addActionListener(new   Manager_Inscription_UI(this));
         //etudInscTab.setModel(new Model_Inscription(Inscription.charger_Inscr_Tableau()));
        //etudInscTab.setModel(new Model_Nouv_Inscription(Nouv_Inscription.Tableau_Inscription()));
        //etudInscTab.getSelectionModel().addListSelectionListener(new Manager_combo_inscription(this));
        //etudInscTab.addMouseListener(new Model_table_selection_Inscription());
        /*AfficherTable();*/
        //btn_Modifier.addActionListener(new Manager_button_modifier());
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    /* ResultSet Rs=null;
public void AfficherTable(){
    
    Rs=db_Mysql.interrogerBD("select * from etudiantinsc");
    etudInscTab.setModel(DbUtils.resultSetToTableModel(Rs));
}*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        recup_id = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        clas = new javax.swing.JComboBox();
        btn_Enregistrer = new javax.swing.JButton();
        btn_Modifier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fac = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        dep = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        etudInscTab = new javax.swing.JTable();
        etud = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        ac = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemfac = new javax.swing.JMenuItem();
        jMenuItemdep = new javax.swing.JMenuItem();
        jMenuItemcl = new javax.swing.JMenuItem();
        jMenuItemetud = new javax.swing.JMenuItem();
        jMenuItemDepcl = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setText("Etudiant");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        recup_id.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        recup_id.setForeground(new java.awt.Color(240, 240, 240));
        recup_id.setText("recup");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(714, 494));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setText("Classe");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        clas.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        btn_Enregistrer.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_Enregistrer.setText("Enregistrer");

        btn_Modifier.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btn_Modifier.setText("Modifier");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setText("Faculté");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setText("Page gérant les inscription des étudiants");

        fac.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setText("Département");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dep.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        etudInscTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(etudInscTab);

        etud.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("Année Academique");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ac.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        ac.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setText("Etudiant");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fac, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(etud, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ac, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btn_Enregistrer)
                        .addGap(71, 71, 71)
                        .addComponent(btn_Modifier))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(etud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Enregistrer)
                    .addComponent(btn_Modifier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jMenu1.setBackground(new java.awt.Color(0, 0, 0));
        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("Menu");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemfac.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemfac.setText("Faculte");
        jMenuItemfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemfacActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemfac);

        jMenuItemdep.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemdep.setText("Departement");
        jMenuItemdep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemdepActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemdep);

        jMenuItemcl.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemcl.setText("Classes");
        jMenuItemcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemclActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemcl);

        jMenuItemetud.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemetud.setText("Etudiant");
        jMenuItemetud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemetudActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemetud);

        jMenuItemDepcl.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDepcl.setText("Depart_Classes");
        jMenuItemDepcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDepclActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDepcl);
        jMenu1.add(jSeparator2);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Quiter");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(recup_id))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(553, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(recup_id)
                .addGap(137, 137, 137)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemclActionPerformed
        // TODO add your handling code here:
        ClasseUI cl=new ClasseUI();
        cl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemclActionPerformed

    private void jMenuItemetudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemetudActionPerformed
        // TODO add your handling code here:
        Etudiants et=new Etudiants();
        et.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemetudActionPerformed

    private void jMenuItemDepclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDepclActionPerformed
        // TODO add your handling code here:
       Dep_Classes dep=new Dep_Classes();
        dep.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemDepclActionPerformed

    private void jMenuItemfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemfacActionPerformed
        // TODO add your handling code here:
        FaculteUI fac=new FaculteUI();
        fac.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemfacActionPerformed

    private void jMenuItemdepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemdepActionPerformed
        // TODO add your handling code here:
        DepartementUI dep=new DepartementUI();
        dep.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemdepActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "vous voulez quiter l'application","Message",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(a==JOptionPane.OK_OPTION)
            this.setVisible(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

     public static Nouv_Inscription i=null;
    static int id;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InscriptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscriptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscriptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscriptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InscriptionUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ac;
    private javax.swing.JButton btn_Enregistrer;
    private javax.swing.JButton btn_Modifier;
    private javax.swing.JComboBox clas;
    private javax.swing.JComboBox dep;
    private javax.swing.JComboBox etud;
    private javax.swing.JTable etudInscTab;
    private javax.swing.JComboBox fac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemDepcl;
    private javax.swing.JMenuItem jMenuItemcl;
    private javax.swing.JMenuItem jMenuItemdep;
    private javax.swing.JMenuItem jMenuItemetud;
    private javax.swing.JMenuItem jMenuItemfac;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel recup_id;
    // End of variables declaration//GEN-END:variables
 
    public JComboBox<Classes> getClas() {
        return clas;
    }

    public JComboBox<Departement> getDep() {
        return dep;
    }

    public JComboBox<Etudiant> getEtud() {
        return etud;
    }

   
    public JComboBox<Faculte> getFac() {
        return  fac;
    }

    public JComboBox<String> getAc() {
        return ac;
    }

    public JTable getEtudInscTab() {
        return etudInscTab;
    }
    public javax.swing.JButton getBtn_Enregistrer() {
        return btn_Enregistrer;
    }
    public javax.swing.JButton getBtn_Modifier() {
        return btn_Modifier;
    }
   
    public int get_index_faculte(Faculte fa){
        Faculte a=null;
        int i=-1;
        if(fa!=null){
            System.out.println(fac.getItemCount());
            for(i=0;i<fac.getItemCount();i++){
                a=(Faculte) fac.getItemAt(i);
                if(fa.getFaculID()==a.getFaculID())
                    return i;
            }
        }
        return i;
    }
    public int get_index_departement(Departement dep)
    {
        Departement depart=null;
        int i=-1;
        if(this.dep!=null)
        {
            for(i=0;i<this.dep.getItemCount();i++)
            {
               depart=(Departement)this.dep.getItemAt(i);
               if(depart.getDepartID()==dep.getDepartID())
               {
                   return i;
               }
            }
        }
        return i;
    }
     public int get_index_cla(Classes f){
        Classes a=null;
        int i=-1;
        if(this.clas!=null){
            for(i=0;i<this.clas.getItemCount();i++){
                a=(Classes)this.clas.getItemAt(i);
                if(f.getClasseId()==a.getClasseId())
                    return i;
            }
        }
        return i;
    }

    public static Nouv_Inscription getInscrID() {
        return inscrID;
    }
     
    public int get_index_etudiant(Etudiant et)
    {
        Etudiant etud=null;
        int i=-1;
        if(this.etud!=null)
        {
            for(i=0;i<this.etud.getItemCount();i++)
            {
                etud=(Etudiant)this.etud.getItemAt(i);
                if(etud.getEtudID()==et.getEtudID())
                    return i;
            }
        }
        return i;
    }
    
    public int get_index_anne_academique(Annee_Academique f){
        Annee_Academique a=null;
        int i=-1;
        if(this.ac!=null){
            for(i=0;i<this.ac.getItemCount();i++){
                a=(Annee_Academique)this.ac.getItemAt(i);
                if(a.getan_acID()==f.getan_acID())
                    return i;
            }
        }
        return i;
    }
    
}
