package application.notebook.page;

import static application.notebook.utils.NotebookConstant.defaultLAF;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import application.MainFrame;
import application.notebook.page._abstract.AbstractPageView;
import application.notebook.page.wholedayeventspanel.WholeDayEventsPanelView;

public class PageView extends AbstractPageView {
    
    private static final int NUMBER_OF_BUTTONS = 20;
    private PageController controller = null;
    private PageModel model = null;
    WholeDayEventsPanelView detaliiZiJLabel = null;
    JPanel jPanel1 = null;
    JPanel jPanel2 = null;
    JScrollPane jScrollPane = null;
    JLabel[] labels = null;
    JButton[] buttons = null;
    
    public PageView(Logger logger) {
    
        super(logger);
        initComponents();
        setFrame();
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    protected void initComponents() {
    
        detaliiZiJLabel = new WholeDayEventsPanelView(getLogger(), this);
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        //                jPanel2.setPreferredSize(new Dimension(500, 500));
        
        /* ----------------------------------------------------------------------------------------- */
        labels = new JLabel[NUMBER_OF_BUTTONS];
        buttons = new JButton[NUMBER_OF_BUTTONS];
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        
        ParallelGroup horizontalParallelGroup = jPanel2Layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup horizontalSequentialGroup = jPanel2Layout.createSequentialGroup();
        ParallelGroup horizontalParallelGroup2 = jPanel2Layout.createParallelGroup(Alignment.LEADING);
        
        ParallelGroup verticalParallelGroup = jPanel2Layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup verticalSequentialGroup = jPanel2Layout.createSequentialGroup();
        
        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
            labels[i] = new JLabel("Label" + i);
            buttons[i] = new JButton("Button" + i);
            
            SequentialGroup horizontalSequentialGroup2 = jPanel2Layout.createSequentialGroup();
            horizontalSequentialGroup2.addComponent(labels[i]);
            horizontalSequentialGroup2.addComponent(buttons[i]);
            horizontalParallelGroup2.addGroup(horizontalSequentialGroup2);
            
            ParallelGroup verticalParallelGroup2 = jPanel2Layout.createParallelGroup(Alignment.LEADING);
            verticalParallelGroup2.addComponent(labels[i]);
            verticalParallelGroup2.addComponent(buttons[i]);
            verticalSequentialGroup.addGroup(verticalParallelGroup2);
        }
        
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        jPanel2Layout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        jPanel2Layout.setVerticalGroup(verticalParallelGroup);
        /* ----------------------------------------------------------------------------------------- */
        
        jScrollPane = new JScrollPane(jPanel2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //        jScrollPane.setPreferredSize(new Dimension((int) jScrollPane.getPreferredSize().getWidth(), (int) jScrollPane.getPreferredSize().getHeight() / 3));
        
        /* ----------------------------------------------------------------------------------------- */
        
        JScrollPane jScrollPane1 = new JScrollPane(detaliiZiJLabel);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        pack();
    }
    
    @Override
    protected void setFrame() {
    
        setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        setMinimumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
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
            
                new PageView(LoggerFactory.getLogger("PageView")).setVisible(true);
            }
        });
    }
    
}
