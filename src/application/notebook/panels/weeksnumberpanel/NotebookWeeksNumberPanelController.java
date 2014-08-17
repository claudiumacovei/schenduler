package application.notebook.panels.weeksnumberpanel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelController;

public class NotebookWeeksNumberPanelController extends AbstractPanelController {
    
    NotebookWeeksNumberPanelModel model = null;
    NotebookWeeksNumberPanelView view = null;
    
    public NotebookWeeksNumberPanelController(Logger logger) {
    
        super(logger);
    }
    
    @Override
    public void initController() {
    
        model = new NotebookWeeksNumberPanelModel(getLogger());
        view = new NotebookWeeksNumberPanelView(this, model, getLogger());
        addModel(model);
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
