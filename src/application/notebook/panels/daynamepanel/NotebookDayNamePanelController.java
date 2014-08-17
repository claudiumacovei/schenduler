package application.notebook.panels.daynamepanel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelController;

public class NotebookDayNamePanelController extends AbstractPanelController {
    NotebookDayNamePanelModel model = null;
    NotebookDayNamePanelView view = null;
    
    public NotebookDayNamePanelController(Logger logger) {
    
        super(logger);
        this.model = new NotebookDayNamePanelModel(logger);
        addModel(model);
    }
    
    @Override
    public void initController() {
    
        this.view = new NotebookDayNamePanelView(this, getLogger());
        addView(view);
    }
    
    public NotebookDayNamePanelModel getModel() {
    
        return model;
    }
    
    public NotebookDayNamePanelView getView() {
    
        return view;
    }
    
    public void setModel(NotebookDayNamePanelModel model) {
    
        this.model = model;
    }
    
    public void setView(NotebookDayNamePanelView view) {
    
        this.view = view;
    }
    
}
