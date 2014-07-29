package notebook;

import static notebook.NotebookConstant.dayNamePannelMinimumHeight;
import static notebook.NotebookConstant.weekNumberPannelMinimumWidht;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import notebookAbstract.AbstractView;

public class NotebookView extends JFrame implements AbstractView {
    private final NotebookController controller;
    private final NotebookModel model;
    private JLabel currentMonthName = new JLabel();
    private NotebookDaysNamePanel dayNamePannel = null;
    private NotebookWeeksNumberPannel weekNumberPannel = null;
    private JPanel daysPannel = new JPanel();
    private NotebookMenuBar menuBar = new NotebookMenuBar();
    private Dimension preferedButtonDimension = new Dimension(73, 73);
    
    public NotebookView(NotebookController controller, NotebookModel model) {
    
        this.controller = controller;
        this.model = model;
        initComponents();
        setFrame();
    }
    
    private void setFrame() {
    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void initComponents() {
    
        setJMenuBar(menuBar);
        currentMonthName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        currentMonthName.setMinimumSize(new Dimension(dayNamePannelMinimumHeight, weekNumberPannelMinimumWidht));
        currentMonthName.setPreferredSize(new Dimension(dayNamePannelMinimumHeight, weekNumberPannelMinimumWidht));
        dayNamePannel = new NotebookDaysNamePanel(model);
        weekNumberPannel = new NotebookWeeksNumberPannel(model);
        
        dayNamePannel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        weekNumberPannel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        daysPannel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        initPannels();
        
        pack();
        
    }
    
    private void initPannels() {
    
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(currentMonthName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(weekNumberPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(dayNamePannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addComponent(daysPannel, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE).addGap(1, 1, 1))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(currentMonthName, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE).addGap(2, 2, 2)).addGroup(layout.createSequentialGroup().addComponent(dayNamePannel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE).addGap(6, 6, 6))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(weekNumberPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addComponent(daysPannel, javax.swing.GroupLayout.PREFERRED_SIZE, 495, Short.MAX_VALUE).addGap(10, 10, 10))).addGap(10, 10, 10)));
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        // TODO Auto-generated method stub
        
    }
    
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
            java.util.logging.Logger.getLogger(NotebookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotebookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotebookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotebookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            
                NotebookController controller = new NotebookController();
                //                new NotebookView(controller, new NotebookModel(controller)).setVisible(true);
            }
        });
    }
    
}
