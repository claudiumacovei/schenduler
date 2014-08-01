package notebook;

import static notebook.utils.NotebookConstant.defaultLAF;
import static notebook.utils.NotebookConstant.gapMaximumSize;
import static notebook.utils.NotebookConstant.gapMinimumSize;
import static notebook.utils.NotebookConstant.gapPreferedSize;

import java.beans.PropertyChangeEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import notebook.abstractc.AbstractView;
import notebook.swing.NotebookDaysNamePanel;
import notebook.swing.NotebookDaysPanel;
import notebook.swing.NotebookMenuBar;
import notebook.swing.NotebookWeeksNumberPanel;
import notebook.swing.currentmonthpanel.NotebookCurrentMonthPanelView;

public class NotebookView extends AbstractView {
    private final NotebookController controller;
    private final NotebookModel model;
    private NotebookCurrentMonthPanelView currentMonthPanel = null;
    private NotebookDaysNamePanel dayNamePannel = null;
    private NotebookWeeksNumberPanel weekNumberPannel = null;
    private NotebookDaysPanel daysPannel = null;
    private NotebookMenuBar menuBar = null;
    
    public NotebookView(NotebookController controller, NotebookModel model) {
    
        this.controller = controller;
        this.model = model;
        initComponents();
        setFrame();
        
    }
    
    private void setFrame() {
    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(menuBar);
        
    }
    
    private void initComponents() {
    
        menuBar = new NotebookMenuBar(controller);
        setJMenuBar(menuBar);
        
        dayNamePannel = model.getNotebookDaysNamePanel();
        weekNumberPannel = model.getNotebookWeeksNumberPannel();
        daysPannel = model.getNotebookDaysPannel();
        currentMonthPanel = model.getNotebookCurrentMonthPanel();
        
        initPannels();
        
        pack();
        
    }
    
    private void initPannels() {
    
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup horizontalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup horizontalParallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup horizontalSequentialGroup2 = layout.createSequentialGroup();
        horizontalSequentialGroup2.addComponent(currentMonthPanel);
        horizontalSequentialGroup2.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalSequentialGroup2.addComponent(dayNamePannel);
        horizontalParallelGroup2.addGroup(horizontalSequentialGroup2);
        horizontalSequentialGroup2 = layout.createSequentialGroup();
        horizontalSequentialGroup2.addComponent(weekNumberPannel);
        horizontalSequentialGroup2.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalSequentialGroup2.addComponent(daysPannel);
        horizontalParallelGroup2.addGroup(horizontalSequentialGroup2);
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        
        layout.setHorizontalGroup(horizontalParallelGroup);
        
        ParallelGroup verticalParallelGroup = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup verticalParallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
        verticalParallelGroup2.addComponent(dayNamePannel);
        verticalParallelGroup2.addComponent(currentMonthPanel);
        verticalSequentialGroup.addGroup(verticalParallelGroup2);
        verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        verticalParallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
        verticalParallelGroup2.addComponent(weekNumberPannel);
        verticalParallelGroup2.addComponent(daysPannel);
        verticalSequentialGroup.addGroup(verticalParallelGroup2);
        verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        
        layout.setVerticalGroup(verticalParallelGroup);
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        setTitle(model.getName());
    }
    
    public static void main(String args[]) {
    
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //                if ("Nimbus".equals(info.getName())) {
                if (defaultLAF.equals(info.getName())) {
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
