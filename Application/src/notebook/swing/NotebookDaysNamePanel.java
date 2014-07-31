package notebook.swing;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.SwingConstants.CENTER;
import static notebook.utils.NotebookConstant.buttonMinimumHeight;
import static notebook.utils.NotebookConstant.buttonMinimumWidth;
import static notebook.utils.NotebookConstant.dayNamePannelMinimumHeight;
import static notebook.utils.NotebookConstant.dayNamePannelMinimumWidth;
import static notebook.utils.NotebookConstant.gapMaximumSize;
import static notebook.utils.NotebookConstant.gapMinimumSize;
import static notebook.utils.NotebookConstant.gapPreferedSize;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;

import notebook.NotebookModel;
import notebook.abstractc.AbstractPanel;

public class NotebookDaysNamePanel extends AbstractPanel {
    NotebookModel model = null;
    private JLabel[] daysName = new JLabel[7];
    
    public NotebookDaysNamePanel(NotebookModel model) {
    
        this.model = model;
        initComponents();
        setPanel();
    }
    
    @Override
    protected void setPanel() {
    
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setMinimumSize(new Dimension(dayNamePannelMinimumWidth, dayNamePannelMinimumHeight));
        setPreferredSize(new Dimension(dayNamePannelMinimumWidth, dayNamePannelMinimumHeight));
    }
    
    @Override
    protected void initComponents() {
    
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        SequentialGroup horizontalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);;
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup verticalParallelGroup = layout.createParallelGroup(LEADING).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        
        for (int i = 0; i < daysName.length; i++) {
            daysName[i] = new JLabel(model.getDayName(i));
            daysName[i].setHorizontalAlignment(CENTER);
            daysName[i].setVerticalAlignment(CENTER);
            daysName[i].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            daysName[i].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            daysName[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            horizontalSequentialGroup.addComponent(daysName[i]);
            horizontalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            verticalParallelGroup.addComponent(daysName[i]);
            verticalParallelGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        }
        
        layout.setHorizontalGroup(horizontalSequentialGroup);
        
        verticalSequentialGroup.addGroup(verticalParallelGroup);
        layout.setVerticalGroup(verticalSequentialGroup);
        
    }
    
}
