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

public class NotebookDaysNamePanel extends JPanel {
    NotebookModel model = null;
    private JLabel[] daysName = new JLabel[7];
    
    public NotebookDaysNamePanel(NotebookModel model) {
    
        this.model = model;
        initComponents();
    }
    
    private void initComponents() {
    
        GroupLayout daysNamePannelLayout = new GroupLayout(this);
        setLayout(daysNamePannelLayout);
        ParallelGroup horizontalParallelGroup = daysNamePannelLayout.createParallelGroup(LEADING);
        SequentialGroup horizontalSequentialGroup = daysNamePannelLayout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup verticalParallelGroup = daysNamePannelLayout.createParallelGroup(LEADING);
        SequentialGroup verticalSequentialGroup = daysNamePannelLayout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup verticalParallelGroup2 = daysNamePannelLayout.createParallelGroup(LEADING);
        
        for (int i = 0; i < daysName.length; i++) {
            //LabelSettings
            daysName[i] = new JLabel();
            daysName[i].setHorizontalAlignment(CENTER);
            daysName[i].setVerticalAlignment(CENTER);
            daysName[i].setText(model.getDayName(i));
            daysName[i].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            daysName[i].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            daysName[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //HorizontalGroup adding
            horizontalSequentialGroup.addComponent(daysName[i], PREFERRED_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            horizontalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            //VerticalGroup adding
            verticalParallelGroup2.addComponent(daysName[i], PREFERRED_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            
        }
        
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        daysNamePannelLayout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalSequentialGroup.addGroup(verticalParallelGroup2);
        verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        daysNamePannelLayout.setVerticalGroup(verticalParallelGroup);
        
    }
}
