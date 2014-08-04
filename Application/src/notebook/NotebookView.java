package notebook;

import static notebook.utils.NotebookConstant.gapMaximumSize;
import static notebook.utils.NotebookConstant.gapMinimumSize;
import static notebook.utils.NotebookConstant.gapPreferedSize;

import java.beans.PropertyChangeEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import notebook.abstractc.AbstractView;
import notebook.swing.NotebookMenuBar;

import org.slf4j.Logger;

public class NotebookView extends AbstractView {
    private final NotebookController controller;
    private final NotebookModel model;
    private NotebookMenuBar menuBar = null;
    
    public NotebookView(NotebookController controller, NotebookModel model, Logger logger) {
    
        super(logger);
        this.controller = controller;
        this.model = model;
        initComponents();
        setFrame();
        
    }
    
    private void setFrame() {
    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(menuBar);
        
    }
    
    private void initComponents() {
    
        menuBar = new NotebookMenuBar(controller, getLogger());
        setJMenuBar(menuBar);
        
        initVariablesFromModel();
        
        initPannels();
        
        pack();
        
    }
    
    private void initVariablesFromModel() {
    
        setTitle(model.getTitle());
        
    }
    
    private void initPannels() {
    
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        ParallelGroup horizontalParallelGroup = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup horizontalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup horizontalParallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup horizontalSequentialGroup2 = layout.createSequentialGroup();
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getView());
        horizontalSequentialGroup2.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getDayNamePanelController().getView());
        horizontalParallelGroup2.addGroup(horizontalSequentialGroup2);
        horizontalSequentialGroup2 = layout.createSequentialGroup();
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getNotebookWeeksNumberPanelController().getView());
        horizontalSequentialGroup2.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getDaysPanelController().getView());
        horizontalParallelGroup2.addGroup(horizontalSequentialGroup2);
        horizontalSequentialGroup.addGroup(horizontalParallelGroup2);
        horizontalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalParallelGroup.addGroup(horizontalSequentialGroup);
        
        layout.setHorizontalGroup(horizontalParallelGroup);
        
        ParallelGroup verticalParallelGroup = layout.createParallelGroup(Alignment.LEADING);
        SequentialGroup verticalSequentialGroup = layout.createSequentialGroup().addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        ParallelGroup verticalParallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
        verticalParallelGroup2.addComponent(controller.getCurrentMonthPanelController().getDayNamePanelController().getView());
        verticalParallelGroup2.addComponent(controller.getCurrentMonthPanelController().getView());
        verticalSequentialGroup.addGroup(verticalParallelGroup2);
        verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        verticalParallelGroup2 = layout.createParallelGroup(Alignment.LEADING);
        verticalParallelGroup2.addComponent(controller.getCurrentMonthPanelController().getNotebookWeeksNumberPanelController().getView());
        verticalParallelGroup2.addComponent(controller.getCurrentMonthPanelController().getDaysPanelController().getView());
        verticalSequentialGroup.addGroup(verticalParallelGroup2);
        verticalSequentialGroup.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        verticalParallelGroup.addGroup(verticalSequentialGroup);
        
        layout.setVerticalGroup(verticalParallelGroup);
    }
    
    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
    
        setTitle(model.getTitle());
    }
    
}
