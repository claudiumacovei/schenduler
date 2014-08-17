package application.notebook;

import static javax.swing.GroupLayout.DEFAULT_SIZE;

import java.beans.PropertyChangeEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractView;

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
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getView(), DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
        horizontalSequentialGroup2.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getDayNamePanelController().getView(), DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
        horizontalParallelGroup2.addGroup(horizontalSequentialGroup2);
        horizontalSequentialGroup2 = layout.createSequentialGroup();
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getNotebookWeeksNumberPanelController().getView(), DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
        horizontalSequentialGroup2.addGap(gapMinimumSize, gapPreferedSize, gapMaximumSize);
        horizontalSequentialGroup2.addComponent(controller.getCurrentMonthPanelController().getDaysPanelController().getView(), DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE);
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
