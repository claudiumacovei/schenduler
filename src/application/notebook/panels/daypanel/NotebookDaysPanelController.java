package application.notebook.panels.daypanel;

import org.slf4j.Logger;

import application.notebook.panels._abstract.AbstractPanelController;

public class NotebookDaysPanelController extends AbstractPanelController {
    private NotebookDaysPanelView view = null;
    private NotebookDaysPanelModel model = null;
    
    public NotebookDaysPanelController(Logger logger) {
    
        super(logger);
    }
    
    @Override
    public void initController() {
    
        model = new NotebookDaysPanelModel(getLogger());
        view = new NotebookDaysPanelView(this, model, getLogger());
        addModel(model);
        addView(view);
    }
    
    public NotebookDaysPanelView getView() {
    
        return view;
    }
    
    public NotebookDaysPanelModel getModel() {
    
        return model;
    }
    
    public void setView(NotebookDaysPanelView view) {
    
        this.view = view;
    }
    
    public void setModel(NotebookDaysPanelModel model) {
    
        this.model = model;
    }
    
}
