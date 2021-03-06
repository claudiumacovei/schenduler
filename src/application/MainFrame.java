package application;

import static application.notebook.utils.NotebookConstant.defaultLAF;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import application.notebook.NotebookController;

public class MainFrame extends JFrame {
    
    private final JButton AdressBookButton = new JButton();
    private final JButton NotebookButton = new JButton();
    private final MainMenuBar menuBar = new MainMenuBar();
    Logger logger = LoggerFactory.getLogger(getClass());
    
    public MainFrame() {
    
        initComponents();
        setFrame();
    }
    
    private void setFrame() {
    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 435));
        
    }
    
    private void initComponents() {
    
        NotebookButton.setIcon(new ImageIcon("Resources/notebook.png"));
        NotebookButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            
                new NotebookController(logger).initController();
                
            }
        });
        
        AdressBookButton.setIcon(new ImageIcon("Resources/adressbook.png"));
        AdressBookButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            
                // TODO Auto-generated method stub
                
            }
        });
        
        setJMenuBar(menuBar);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(NotebookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(AdressBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(NotebookButton, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE).addComponent(AdressBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)).addContainerGap()));
        
        pack();
    }
    
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (defaultLAF.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            
                new MainFrame().setVisible(true);
            }
        });
    }
}
