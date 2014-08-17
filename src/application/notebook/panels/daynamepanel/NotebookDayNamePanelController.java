package application.notebook.panels.daynamepanel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelController;

public class NotebookDayNamePanelController extends AbstractPanelController {
    NotebookDayNamePanelModel model = null;
    NotebookDayNamePanelView view = null;
    
    public NotebookDayNamePanelController(Logger logger) {
    
        super(logger);
        
    }
    
    public NotebookDayNamePanelController initController() {
    
        model = new NotebookDayNamePanelModel(getLogger());
        view = new NotebookDayNamePanelView(this, model, getLogger());
        addModel(model);
        addView(view);
        return this;
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
