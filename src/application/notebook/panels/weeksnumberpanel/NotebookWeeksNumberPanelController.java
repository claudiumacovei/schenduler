package application.notebook.panels.weeksnumberpanel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelController;

public class NotebookWeeksNumberPanelController extends AbstractPanelController {
    
    NotebookWeeksNumberPanelModel model = null;
    NotebookWeeksNumberPanelView view = null;
    
    public NotebookWeeksNumberPanelController(Logger logger) {
    
        super(logger);
        model = new NotebookWeeksNumberPanelModel(logger);
        addModel(model);
    }
    
    @Override
    public void initController() {
    
        view = new NotebookWeeksNumberPanelView(this, getLogger());
        addView(view);
    }
    
    public NotebookWeeksNumberPanelModel getModel() {
    
        return model;
    }
    
    public NotebookWeeksNumberPanelView getView() {
    
        return view;
    }
    
    public void setModel(NotebookWeeksNumberPanelModel model) {
    
        this.model = model;
    }
    
    public void setView(NotebookWeeksNumberPanelView view) {
    
        this.view = view;
    }
    
}
