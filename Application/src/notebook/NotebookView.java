package notebook;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import notebookAbstract.AbstractView;

public class NotebookView extends JFrame implements AbstractView {
    private final NotebookController controller;
    private final NotebookModel model;
    private JLabel currentMounthName = new JLabel();
    private JPanel dayNamePannel = new JPanel();
    private JPanel weekNumberPannel = new JPanel();
    private JPanel daysPannel = new JPanel();
    private JLabel[] daysName = new JLabel[7];
    private JLabel[] weekNo = new JLabel[6];
    private JButton[][] days = new JButton[6][7];
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
    
        initDaysNameLabels();
        initWeeksNumberLabels();
        initDaysButtons();
        currentMounthName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        currentMounthName.setMinimumSize(new Dimension(95, 95));
        currentMounthName.setPreferredSize(new Dimension(95, 95));
        
        dayNamePannel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        weekNumberPannel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        daysPannel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        initPannels();
        
        pack();
        
    }
    
    private void initDaysButtons() {
    
        GroupLayout daysPannelLayout = new GroupLayout(daysPannel);
        daysPannel.setLayout(daysPannelLayout);
        
        ParallelGroup horizontalParallelGroup = daysPannelLayout.createParallelGroup(LEADING);
        SequentialGroup horizontalSequentialGroup = daysPannelLayout.createSequentialGroup().addContainerGap();
        ParallelGroup horizontalParallelGroup2 = daysPannelLayout.createParallelGroup(LEADING);
        
        ParallelGroup verticalParallelGroup = daysPannelLayout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = daysPannelLayout.createSequentialGroup().addContainerGap();
        
        for (int i = 0; i < days.length; i++) {
            SequentialGroup horizontalLocalSequentialGroup = daysPannelLayout.createSequentialGroup();
            ParallelGroup verticalLocalParallelGroup = daysPannelLayout.createParallelGroup(BASELINE);
            days[i] = new JButton[7];
            for (int j = 0; j < days[i].length; j++) {
                days[i][j] = new JButton();
                days[i][j].setText(model.getDayNumber(i, j));
                days[i][j].setMinimumSize(preferedButtonDimension);
                days[i][j].setPreferredSize(preferedButtonDimension);
                
                horizontalLocalSequentialGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
                if (j != days[i].length)
                    horizontalLocalSequentialGroup.addPreferredGap(RELATED);
                verticalLocalParallelGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            }
            
            horizontalParallelGroup2.addGroup(horizontalLocalSequentialGroup);
            verticalSequentialGroup.addGroup(verticalLocalParallelGroup);
        }
        
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalSequentialGroup.addContainerGap();
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        daysPannelLayout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalSequentialGroup.addContainerGap();
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        daysPannelLayout.setVerticalGroup(verticalParallelGroup);
    }
    
    private void initWeeksNumberLabels() {
    
        GroupLayout weekNumberPannelLayout = new GroupLayout(weekNumberPannel);
        weekNumberPannel.setLayout(weekNumberPannelLayout);
        
        //Create horizontal group initial
        ParallelGroup horizontalParallelGroup = weekNumberPannelLayout.createParallelGroup(LEADING);
        SequentialGroup horizontalSequentialGroup = weekNumberPannelLayout.createSequentialGroup().addContainerGap();
        ParallelGroup horizontalParallelGroup2 = weekNumberPannelLayout.createParallelGroup(LEADING);
        
        //Create vertical group initial
        ParallelGroup verticalParallelGroup = weekNumberPannelLayout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = weekNumberPannelLayout.createSequentialGroup().addContainerGap();
        
        for (int i = 0; i < weekNo.length; i++) {
            
            weekNo[i] = new JLabel();
            weekNo[i].setText(model.getWeekNumber(i));
            weekNo[i].setMinimumSize(preferedButtonDimension);
            weekNo[i].setPreferredSize(preferedButtonDimension);
            
            horizontalParallelGroup2.addComponent(weekNo[i], PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE);
            verticalSequentialGroup.addComponent(weekNo[i], PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE);
            if (i != weekNo.length)
                verticalSequentialGroup.addPreferredGap(RELATED);
            
        }
        //Set final for horizontal group
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalSequentialGroup.addContainerGap();
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        weekNumberPannelLayout.setHorizontalGroup(horizontalParallelGroup);
        
        //Set final for vertical Group
        verticalSequentialGroup.addContainerGap();
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        weekNumberPannelLayout.setVerticalGroup(verticalParallelGroup);
    }
    
    private void initPannels() {
    
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(currentMounthName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(weekNumberPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(dayNamePannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addComponent(daysPannel, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE).addGap(1, 1, 1))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(currentMounthName, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE).addGap(2, 2, 2)).addGroup(layout.createSequentialGroup().addComponent(dayNamePannel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE).addGap(6, 6, 6))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(weekNumberPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addComponent(daysPannel, javax.swing.GroupLayout.PREFERRED_SIZE, 495, Short.MAX_VALUE).addGap(10, 10, 10))).addGap(10, 10, 10)));
    }
    
    private void initDaysNameLabels() {
    
        GroupLayout daysNamePannelLayout = new GroupLayout(dayNamePannel);
        dayNamePannel.setLayout(daysNamePannelLayout);
        ParallelGroup horizontalParallelGroup = daysNamePannelLayout.createParallelGroup(LEADING);
        SequentialGroup horizontalSequentialGroup = daysNamePannelLayout.createSequentialGroup().addContainerGap();
        ParallelGroup verticalParallelGroup = daysNamePannelLayout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = daysNamePannelLayout.createSequentialGroup().addContainerGap();
        ParallelGroup verticalParallelGroup2 = daysNamePannelLayout.createParallelGroup(LEADING);
        
        for (int i = 0; i < daysName.length; i++) {
            daysName[i] = new JLabel();
            daysName[i].setText(model.getDayName(i));
            daysName[i].setMinimumSize(preferedButtonDimension);
            daysName[i].setPreferredSize(preferedButtonDimension);
            daysName[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            horizontalSequentialGroup.addComponent(daysName[i], PREFERRED_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            if (i != daysName.length)
                horizontalSequentialGroup.addPreferredGap(RELATED);
            else
                horizontalSequentialGroup.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE);
            
            verticalParallelGroup2.addComponent(daysName[i], PREFERRED_SIZE, 0, Short.MAX_VALUE);
            
        }
        
        horizontalSequentialGroup.addContainerGap();
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        daysNamePannelLayout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalSequentialGroup.addGroup(verticalParallelGroup2).addContainerGap();
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        daysNamePannelLayout.setVerticalGroup(verticalParallelGroup);
        
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
            public void run() {
            
                NotebookController controller = new NotebookController();
                //                new NotebookView(controller, new NotebookModel(controller)).setVisible(true);
            }
        });
    }
    
}
