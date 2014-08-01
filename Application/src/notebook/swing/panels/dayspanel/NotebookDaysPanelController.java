package notebook.swing.panels.dayspanel;

import notebook.swing.panels.abstractc.AbstractPanelController;

import org.slf4j.Logger;

public class NotebookDaysPanelController extends AbstractPanelController {
    private NotebookDaysPanelView view = null;
    private NotebookDaysPanelModel model = null;
    
    public NotebookDaysPanelController(Logger logger) {
    
        super(logger);
        model = new NotebookDaysPanelModel(logger);
        view = new NotebookDaysPanelView(model, this);
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
