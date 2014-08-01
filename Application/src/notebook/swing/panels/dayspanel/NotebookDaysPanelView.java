package notebook.swing.panels.dayspanel;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.SwingConstants.CENTER;
import static notebook.utils.NotebookConstant.buttonMinimumHeight;
import static notebook.utils.NotebookConstant.buttonMinimumWidth;
import static notebook.utils.NotebookConstant.dayNamePannelMinimumWidth;
import static notebook.utils.NotebookConstant.gapMaximumSize;
import static notebook.utils.NotebookConstant.gapMinimumSize;
import static notebook.utils.NotebookConstant.gapPreferedSize;
import static notebook.utils.NotebookConstant.weekNumberPannelMinimumHeight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;

import notebook.swing.panels.abstractc.AbstractPanelView;

import org.slf4j.Logger;

public class NotebookDaysPanelView extends AbstractPanelView {
    NotebookDaysPanelModel model = null;
    NotebookDaysPanelController controller = null;
    private JButton[][] days = new JButton[6][7];
    
    public NotebookDaysPanelView(NotebookDaysPanelController controller, NotebookDaysPanelModel model, Logger logger) {
    
        super(logger);
        this.controller = controller;
        this.model = model;
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
            days[i] = new JButton[7];
            for (int j = 0; j < days[i].length; j++) {
                days[i][j] = new JButton(model.getDayNumber(i, j));
                days[i][j].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
                days[i][j].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
                days[i][j].setHorizontalAlignment(CENTER);
                days[i][j].setVerticalAlignment(CENTER);
                final int currentI = i;
                final int currentJ = j;
                days[i][j].addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                    
                        daysButtonActionPerformed(currentI, currentJ, arg0);
                        
                    }
                    
                    private void daysButtonActionPerformed(int currentI, int currentJ, ActionEvent arg0) {
                    
                        getLogger().warn("DayButtonPressed: i=" + currentI + " j=" + currentJ + " actionEvent: " + arg0);
                    }
                });
                
                horizontalLocalSequentialGroup.addComponent(days[i][j]);
                if (j != days[i].length)
                    horizontalLocalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
                
                verticalLocalParallelGroup.addComponent(days[i][j]);
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
    
        // TODO Auto-generated method stub
        
    }
    
}
