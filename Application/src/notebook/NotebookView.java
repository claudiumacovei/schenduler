package notebook;

import static notebook.NotebookConstant.dayNamePannelMinimumHeight;
import static notebook.NotebookConstant.gapMaximumSize;
import static notebook.NotebookConstant.gapMinimumSize;
import static notebook.NotebookConstant.gapPreferedSize;
import static notebook.NotebookConstant.weekNumberPannelMinimumWidht;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;

import notebookAbstract.AbstractView;

public class NotebookView extends JFrame implements AbstractView {
    private final NotebookController controller;
    private final NotebookModel model;
    private JLabel currentMonthName = new JLabel();
    private NotebookDaysNamePanel dayNamePannel = null;
    private NotebookWeeksNumberPannel weekNumberPannel = null;
    private NotebookDaysPannel daysPannel = null;
    private NotebookMenuBar menuBar = new NotebookMenuBar();
    
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
    
        setJMenuBar(menuBar);
        currentMonthName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        currentMonthName.setMinimumSize(new Dimension(dayNamePannelMinimumHeight, weekNumberPannelMinimumWidht));
        currentMonthName.setPreferredSize(new Dimension(dayNamePannelMinimumHeight, weekNumberPannelMinimumWidht));
        
        dayNamePannel = new NotebookDaysNamePanel(model);
        weekNumberPannel = new NotebookWeeksNumberPannel(model);
        daysPannel = new NotebookDaysPannel(model);
        
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
        horizontalSequentialGroup2.addComponent(currentMonthName);
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
        verticalParallelGroup2.addComponent(currentMonthName);
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
