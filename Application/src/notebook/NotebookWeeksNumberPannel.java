package notebook;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.SwingConstants.CENTER;
import static notebook.NotebookConstant.buttonMinimumHeight;
import static notebook.NotebookConstant.buttonMinimumWidth;
import static notebook.NotebookConstant.gapMaximumSize;
import static notebook.NotebookConstant.gapMinimumSize;
import static notebook.NotebookConstant.gapPreferedSize;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NotebookWeeksNumberPannel extends JPanel {
    private NotebookModel model = null;
    private JLabel[] weekNumber = new JLabel[6];
    
    public NotebookWeeksNumberPannel(NotebookModel model) {
    
        this.model = model;
        initComponents();
    }
    
    private void initComponents() {
    
        GroupLayout weekNumberPannelLayout = new GroupLayout(this);
        setLayout(weekNumberPannelLayout);
        
        //Create horizontal group initial
        ParallelGroup horizontalParallelGroup = weekNumberPannelLayout.createParallelGroup(LEADING);
        SequentialGroup horizontalSequentialGroup = weekNumberPannelLayout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup horizontalParallelGroup2 = weekNumberPannelLayout.createParallelGroup(LEADING);
        
        //Create vertical group initial
        ParallelGroup verticalParallelGroup = weekNumberPannelLayout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = weekNumberPannelLayout.createSequentialGroup().addContainerGap();
        
        for (int i = 0; i < weekNumber.length; i++) {
            
            weekNumber[i] = new JLabel();
            weekNumber[i].setText(model.getWeekNumber(i));
            weekNumber[i].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            weekNumber[i].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            weekNumber[i].setHorizontalAlignment(CENTER);
            weekNumber[i].setVerticalAlignment(CENTER);
            weekNumber[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            horizontalParallelGroup2.addComponent(weekNumber[i], PREFERRED_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            
            verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            verticalSequentialGroup.addComponent(weekNumber[i], PREFERRED_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            
        }
        //Set final for horizontal group
        horizontalParallelGroup2.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalSequentialGroup.addContainerGap();
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        weekNumberPannelLayout.setHorizontalGroup(horizontalParallelGroup);
        
        //Set final for vertical Group
        verticalSequentialGroup.addContainerGap();
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        weekNumberPannelLayout.setVerticalGroup(verticalParallelGroup);
        
    }
}
