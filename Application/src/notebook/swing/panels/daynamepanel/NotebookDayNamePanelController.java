package notebook.swing.panels.daynamepanel;

import notebook.swing.panels.abstractc.AbstractPanelController;

import org.slf4j.Logger;

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
