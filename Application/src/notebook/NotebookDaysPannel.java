package notebook;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.SwingConstants.CENTER;
import static notebook.NotebookConstant.buttonMinimumHeight;
import static notebook.NotebookConstant.buttonMinimumWidth;
import static notebook.NotebookConstant.dayNamePannelMinimumWidth;
import static notebook.NotebookConstant.gapMaximumSize;
import static notebook.NotebookConstant.gapMinimumSize;
import static notebook.NotebookConstant.gapPreferedSize;
import static notebook.NotebookConstant.weekNumberPannelMinimumHeight;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NotebookDaysPannel extends JPanel {
    NotebookModel model = null;
    private JButton[][] days = new JButton[6][7];
    
    public NotebookDaysPannel(NotebookModel model) {
    
        this.model = model;
        //        initComponents();
        initComponents2();
        setPanel();
    }
    
    private void initComponents2() {
    
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(Alignment.CENTER).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        
        ParallelGroup verticalParallelGroup = layout.createParallelGroup(LEADING).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        
        for (int i = 0; i < days.length; i++) {
            SequentialGroup horizontalLocalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            ParallelGroup verticalLocalParallelGroup = layout.createParallelGroup(LEADING).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
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
                    
                        System.out.println("DayButtonPressed: i=" + currentI + " j=" + currentJ + " actionEvent: " + arg0);
                        
                    }
                });
                
                horizontalLocalSequentialGroup.addComponent(days[i][j]);
                horizontalLocalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
                verticalLocalParallelGroup.addComponent(days[i][j]);
                verticalLocalParallelGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            }
            
            horizontalParallelGroup.addGroup(horizontalLocalSequentialGroup);
            horizontalParallelGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            
            verticalSequentialGroup.addGroup(verticalLocalParallelGroup);
            verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        }
        
        layout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        verticalParallelGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        layout.setVerticalGroup(verticalParallelGroup);
    }
    
    private void setPanel() {
    
        setMinimumSize(new Dimension(weekNumberPannelMinimumHeight, dayNamePannelMinimumWidth));
        setPreferredSize(new Dimension(weekNumberPannelMinimumHeight, dayNamePannelMinimumWidth));
        
    }
    
    private void initComponents() {
    
        GroupLayout daysPannelLayout = new GroupLayout(this);
        setLayout(daysPannelLayout);
        
        ParallelGroup horizontalParallelGroup = daysPannelLayout.createParallelGroup(LEADING);
        SequentialGroup horizontalSequentialGroup = daysPannelLayout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup horizontalParallelGroup2 = daysPannelLayout.createParallelGroup(LEADING);
        
        ParallelGroup verticalParallelGroup = daysPannelLayout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = daysPannelLayout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        
        for (int i = 0; i < days.length; i++) {
            SequentialGroup horizontalLocalSequentialGroup = daysPannelLayout.createSequentialGroup();
            ParallelGroup verticalLocalParallelGroup = daysPannelLayout.createParallelGroup(BASELINE);
            days[i] = new JButton[7];
            for (int j = 0; j < days[i].length; j++) {
                days[i][j] = new JButton();
                days[i][j].setText(model.getDayNumber(i, j));
                days[i][j].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
                days[i][j].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
                days[i][j].setHorizontalAlignment(CENTER);
                days[i][j].setVerticalAlignment(CENTER);
                
                horizontalLocalSequentialGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
                horizontalLocalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
                verticalLocalParallelGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            }
            
            horizontalParallelGroup2.addGroup(horizontalLocalSequentialGroup);
            verticalSequentialGroup.addGroup(verticalLocalParallelGroup);
            verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        }
        
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        //        horizontalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        daysPannelLayout.setHorizontalGroup(horizontalParallelGroup);
        
        //        verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        daysPannelLayout.setVerticalGroup(verticalParallelGroup);
    }
}
