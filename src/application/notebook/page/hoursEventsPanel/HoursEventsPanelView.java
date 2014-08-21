package application.notebook.page.hoursEventsPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelView;

public class HoursEventsPanelView extends AbstractPanelView {
    
    private static final int NUMBER_OF_BUTTONS = 50;
    JLabel[] labels = null;
    JButton[] buttons = null;
    
    public HoursEventsPanelView(Logger logger) {
    
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
    
        labels = new JLabel[NUMBER_OF_BUTTONS];
        buttons = new JButton[NUMBER_OF_BUTTONS];
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(Alignment.LEADING);
        
        ParallelGroup verticalParallelGroup = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup();
        
        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
            labels[i] = new JLabel("Label" + i);
            labels[i].setPreferredSize(new Dimension(200, 100));
            labels[i].setBorder(BorderFactory.createLineBorder(Color.black));
            buttons[i] = new JButton("Button" + i);
            
            SequentialGroup horizontalSequentialGroup2 = layout.createSequentialGroup();
            horizontalSequentialGroup2.addComponent(labels[i], 200, 200, 200);
            horizontalSequentialGroup2.addGap(0, 0, 0);
            horizontalSequentialGroup2.addComponent(buttons[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            horizontalParallelGroup.addGroup(horizontalSequentialGroup2);
            
            ParallelGroup verticalParallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
            verticalParallelGroup2.addComponent(labels[i], 50, 50, 50);
            verticalParallelGroup2.addComponent(buttons[i], 50, 50, 50);
            verticalSequentialGroup.addGroup(verticalParallelGroup2);
            verticalSequentialGroup.addGap(0, 0, 0);
        }
        
        layout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        layout.setVerticalGroup(verticalParallelGroup);
        
    }
    
    @Override
    protected void setPanel() {
    
        setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 15, 3 * ((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4)));
        
    }
    
}
