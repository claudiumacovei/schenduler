package application.notebook.panels.weeksnumberpanel;

import static application.notebook.utils.NotebookConstant.buttonMinimumHeight;
import static application.notebook.utils.NotebookConstant.buttonMinimumWidth;
import static application.notebook.utils.NotebookConstant.gapMaximumSize;
import static application.notebook.utils.NotebookConstant.gapMinimumSize;
import static application.notebook.utils.NotebookConstant.gapPreferedSize;
import static application.notebook.utils.NotebookConstant.weekNumberPannelMinimumHeight;
import static application.notebook.utils.NotebookConstant.weekNumberPannelMinimumWidht;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.SwingConstants.CENTER;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelView;

public class NotebookWeeksNumberPanelView extends AbstractPanelView {
    private NotebookWeeksNumberPanelController controller = null;
    private JLabel[] weekNumber = new JLabel[6];
    
    public NotebookWeeksNumberPanelView(NotebookWeeksNumberPanelController controller, Logger logger) {
    
        super(logger);
        this.controller = controller;
        initComponents();
        setPanel();
    }
    
    @Override
    protected void setPanel() {
    
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setMinimumSize(new Dimension(weekNumberPannelMinimumWidht, weekNumberPannelMinimumHeight));
        setPreferredSize(new Dimension(weekNumberPannelMinimumWidht, weekNumberPannelMinimumHeight));
        
    }
    
    @Override
    protected void initComponents() {
    
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(LEADING).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        
        for (int i = 0; i < weekNumber.length; i++) {
            SequentialGroup horizontalLocalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            ParallelGroup verticalLocalParallelGroup = layout.createParallelGroup(LEADING).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            weekNumber[i] = new JLabel();
            weekNumber[i].setText(controller.getModel().getWeekNumber(i));
            weekNumber[i].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            weekNumber[i].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            weekNumber[i].setHorizontalAlignment(CENTER);
            weekNumber[i].setVerticalAlignment(CENTER);
            weekNumber[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            horizontalLocalSequentialGroup.addComponent(weekNumber[i], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            horizontalLocalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            horizontalParallelGroup.addGroup(horizontalLocalSequentialGroup);
            
            verticalLocalParallelGroup.addComponent(weekNumber[i], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            verticalLocalParallelGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            verticalSequentialGroup.addGroup(verticalLocalParallelGroup);
            verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            
        }
        
        layout.setHorizontalGroup(horizontalParallelGroup);
        layout.setVerticalGroup(verticalSequentialGroup);
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        for (int i = 0; i < weekNumber.length; i++)
            weekNumber[i].setText(controller.getModel().getWeekNumber(i));
        
    }
    
}
