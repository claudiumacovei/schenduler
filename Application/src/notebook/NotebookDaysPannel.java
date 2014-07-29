package notebook;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.Alignment.BASELINE;
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
import javax.swing.JButton;
import javax.swing.JPanel;

public class NotebookDaysPannel extends JPanel {
    NotebookModel model = null;
    private JButton[][] days = new JButton[6][7];
    
    public NotebookDaysPannel(NotebookModel model) {
    
        this.model = model;
        initComponents();
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
                days[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                days[i][j].setHorizontalAlignment(CENTER);
                days[i][j].setVerticalAlignment(CENTER);
                
                horizontalLocalSequentialGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
                verticalLocalParallelGroup.addComponent(days[i][j], DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
            }
            
            horizontalParallelGroup2.addGroup(horizontalLocalSequentialGroup);
            verticalSequentialGroup.addGroup(verticalLocalParallelGroup);
        }
        
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalSequentialGroup.addContainerGap();
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        daysPannelLayout.setHorizontalGroup(horizontalParallelGroup);
        
        verticalSequentialGroup.addContainerGap();
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        daysPannelLayout.setVerticalGroup(verticalParallelGroup);
    }
}
