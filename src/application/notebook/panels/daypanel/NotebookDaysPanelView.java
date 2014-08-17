package application.notebook.panels.daypanel;

import static application.notebook.utils.NotebookConstant.buttonMinimumHeight;
import static application.notebook.utils.NotebookConstant.buttonMinimumWidth;
import static application.notebook.utils.NotebookConstant.dayNamePannelMinimumWidth;
import static application.notebook.utils.NotebookConstant.gapMaximumSize;
import static application.notebook.utils.NotebookConstant.gapMinimumSize;
import static application.notebook.utils.NotebookConstant.gapPreferedSize;
import static application.notebook.utils.NotebookConstant.weekNumberPannelMinimumHeight;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.SwingConstants.CENTER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import org.slf4j.Logger;

import application.notebook.page.PageController;
import application.notebook.panels._abstract.AbstractPanelView;

public class NotebookDaysPanelView extends AbstractPanelView {
    NotebookDaysPanelController controller = null;
    private NotebookDayButton[][] days = new NotebookDayButton[6][7];
    
    public NotebookDaysPanelView(NotebookDaysPanelController controller, Logger logger) {
    
        super(logger);
        this.controller = controller;
        initComponents();
        setPanel();
    }
    
    @Override
    protected void setPanel() {
    
        setMinimumSize(new Dimension(dayNamePannelMinimumWidth, weekNumberPannelMinimumHeight));
        setPreferredSize(new Dimension(dayNamePannelMinimumWidth, weekNumberPannelMinimumHeight));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
    protected void initComponents() {
    
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(LEADING);
        SequentialGroup horizontalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup horizontalParallelGroup2 = layout.createParallelGroup(LEADING);
        
        ParallelGroup verticalParallelGroup = layout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        
        for (int i = 0; i < days.length; i++) {
            SequentialGroup horizontalLocalSequentialGroup = layout.createSequentialGroup();
            ParallelGroup verticalLocalParallelGroup = layout.createParallelGroup(BASELINE);
            days[i] = new NotebookDayButton[7];
            for (int j = 0; j < days[i].length; j++) {
                days[i][j] = controller.getModel().getDayButton(i, j);
                days[i][j].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
                days[i][j].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
                days[i][j].setHorizontalAlignment(CENTER);
                days[i][j].setVerticalAlignment(CENTER);
                days[i][j].addActionListener(new DayButtonActionListener(days[i][j]));
                
                horizontalLocalSequentialGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
                if (j != days[i].length)
                    horizontalLocalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
                
                verticalLocalParallelGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            }
            
            horizontalParallelGroup2.addGroup(horizontalLocalSequentialGroup);
            
            verticalSequentialGroup.addGroup(verticalLocalParallelGroup);
            verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        }
        
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        layout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        layout.setVerticalGroup(verticalParallelGroup);
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < days[i].length; j++) {
                days[i][j] = controller.getModel().getDayButton(i, j);
            }
        }
        
    }
    
    private final class DayButtonActionListener implements ActionListener {
        
        NotebookDayButton dayButton = null;
        
        public DayButtonActionListener(NotebookDayButton dayButton) {
        
            super();
            this.dayButton = dayButton;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
            new PageController(getLogger(), dayButton);
        }
        
    }
}
