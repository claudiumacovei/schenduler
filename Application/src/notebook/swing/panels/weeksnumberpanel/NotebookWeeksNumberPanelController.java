package notebook.swing.panels.weeksnumberpanel;

import notebook.swing.panels.abstractc.AbstractPanelController;

import org.slf4j.Logger;

public class NotebookWeeksNumberPanelController extends AbstractPanelController {
    
    NotebookWeeksNumberPanelModel model = null;
    NotebookWeeksNumberPanelView view = null;
    
    public NotebookWeeksNumberPanelController(Logger logger) {
    
        super(logger);
        model = new NotebookWeeksNumberPanelModel(logger);
        view = new NotebookWeeksNumberPanelView(model);
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
