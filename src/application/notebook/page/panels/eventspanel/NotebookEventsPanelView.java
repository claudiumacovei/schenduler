package application.notebook.page.panels.eventspanel;

import static application.notebook.page.utils.NotebookPageContant.eventLength;
import static javax.swing.GroupLayout.Alignment.LEADING;

import java.beans.PropertyChangeEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelView;

public class NotebookEventsPanelView extends AbstractPanelView {
    
    JLabel[] timeIntervalUnits = new JLabel[24 * 60 / eventLength];
    JButton[] eventsButtons = new JButton[24 * 60 / eventLength];
    
    public NotebookEventsPanelView(Logger logger) {
    
        super(logger);
        initComponents();
        setPanel();
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    protected void initComponents() {
    
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(LEADING);
        ParallelGroup verticalParallelGroup = layout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup();
        
        for (int i = 0; i < timeIntervalUnits.length; i++) {
            timeIntervalUnits[i] = new JLabel(i + "");
            eventsButtons[i] = new JButton(i + "");
            eventsButtons[i].addActionListener(new NotebookEventsPanelButtonActionListener(getLogger()));
            
            SequentialGroup horizontalSequentialGroup = layout.createSequentialGroup();
            horizontalSequentialGroup.addComponent(timeIntervalUnits[i], 50, 50, 50);
            horizontalSequentialGroup.addGap(0, 0, 0);
            horizontalSequentialGroup.addComponent(eventsButtons[i]);
            
            horizontalParallelGroup.addGroup(horizontalSequentialGroup);
            
            ParallelGroup verticalParallelGroup2 = layout.createParallelGroup(LEADING, false);
            verticalParallelGroup2.addComponent(eventsButtons[i]);
            verticalParallelGroup2.addComponent(timeIntervalUnits[i]);
            verticalSequentialGroup.addGroup(verticalParallelGroup2);
            verticalSequentialGroup.addGap(0, 0, 0);
            
        }
        
        layout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        layout.setVerticalGroup(verticalParallelGroup);
    }
    
    @Override
    protected void setPanel() {
    
        // TODO Auto-generated method stub
        
    }
    
}
