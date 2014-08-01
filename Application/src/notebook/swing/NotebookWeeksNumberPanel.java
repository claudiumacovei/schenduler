package notebook.swing;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.SwingConstants.CENTER;
import static notebook.utils.NotebookConstant.buttonMinimumHeight;
import static notebook.utils.NotebookConstant.buttonMinimumWidth;
import static notebook.utils.NotebookConstant.gapMaximumSize;
import static notebook.utils.NotebookConstant.gapMinimumSize;
import static notebook.utils.NotebookConstant.gapPreferedSize;
import static notebook.utils.NotebookConstant.weekNumberPannelMinimumHeight;
import static notebook.utils.NotebookConstant.weekNumberPannelMinimumWidht;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;

import notebook.NotebookModel;
import notebook.swing.panels.abstractc.AbstractPanelView;

public class NotebookWeeksNumberPanel extends AbstractPanelView {
    private NotebookModel model = null;
    private JLabel[] weekNumber = new JLabel[6];
    
    public NotebookWeeksNumberPanel(NotebookModel model) {
    
        this.model = model;
        initComponents();
        setPanel();
    }
    
    @Override
    protected void setPanel() {
    
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setMinimumSize(new Dimension(weekNumberPannelMinimumWidht, weekNumberPannelMinimumHeight));
        setPreferredSize(new Dimension(weekNumberPannelMinimumWidht, weekNumberPannelMinimumHeight));
        
    }
    
    protected void initComponents() {
    
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(LEADING).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        
        for (int i = 0; i < weekNumber.length; i++) {
            SequentialGroup horizontalLocalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            ParallelGroup verticalLocalParallelGroup = layout.createParallelGroup(LEADING).addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            weekNumber[i] = new JLabel();
            weekNumber[i].setText(model.getWeekNumber(i));
            weekNumber[i].setMinimumSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            weekNumber[i].setPreferredSize(new Dimension(buttonMinimumHeight, buttonMinimumWidth));
            weekNumber[i].setHorizontalAlignment(CENTER);
            weekNumber[i].setVerticalAlignment(CENTER);
            weekNumber[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            horizontalLocalSequentialGroup.addComponent(weekNumber[i]);
            horizontalLocalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            horizontalParallelGroup.addGroup(horizontalLocalSequentialGroup);
            
            verticalLocalParallelGroup.addComponent(weekNumber[i]);
            verticalLocalParallelGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            verticalSequentialGroup.addGroup(verticalLocalParallelGroup);
            verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
            
        }
        
        layout.setHorizontalGroup(horizontalParallelGroup);
        layout.setVerticalGroup(verticalSequentialGroup);
    }
    
}
