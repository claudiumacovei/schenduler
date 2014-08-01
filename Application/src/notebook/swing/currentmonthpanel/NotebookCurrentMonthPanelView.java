package notebook.swing.currentmonthpanel;

import static javax.swing.SwingConstants.CENTER;
import static notebook.utils.NotebookConstant.dayNamePannelMinimumHeight;
import static notebook.utils.NotebookConstant.weekNumberPannelMinimumWidht;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import notebook.NotebookModel;
import notebook.abstractc.AbstractPanel;

public class NotebookCurrentMonthPanelView extends AbstractPanel {
    NotebookModel model = null;
    JLabel currentMonthName = new JLabel();
    JButton previousMonthButton = new JButton("<");
    JButton nextMonthButton = new JButton(">");
    
    public NotebookCurrentMonthPanelView(NotebookModel model) {
    
        this.model = model;
        initComponents();
        setPanel();
    }
    
    @Override
    protected void initComponents() {
    
        currentMonthName.setMinimumSize(new java.awt.Dimension(80, 40));
        currentMonthName.setPreferredSize(new java.awt.Dimension(80, 40));
        currentMonthName.setHorizontalAlignment(CENTER);
        currentMonthName.setText(model.getCurrentMonthName() + " " + model.getCurrentYear());
        previousMonthButton.setMinimumSize(new java.awt.Dimension(40, 20));
        previousMonthButton.setPreferredSize(new java.awt.Dimension(40, 20));
        nextMonthButton.setMinimumSize(new java.awt.Dimension(40, 20));
        nextMonthButton.setPreferredSize(new java.awt.Dimension(40, 20));
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(currentMonthName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(previousMonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(4, 4, 4).addComponent(nextMonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(currentMonthName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(15, 15, 15).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(previousMonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(nextMonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(15, 15, 15)));
    }
    
    @Override
    protected void setPanel() {
    
        setMinimumSize(new Dimension(weekNumberPannelMinimumWidht, dayNamePannelMinimumHeight));
        setPreferredSize(new Dimension(weekNumberPannelMinimumWidht, dayNamePannelMinimumHeight));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
    }
    
}