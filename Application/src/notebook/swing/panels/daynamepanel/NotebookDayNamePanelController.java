package notebook.swing.panels.daynamepanel;

import notebook.swing.panels.abstractc.AbstractPanelController;

import org.slf4j.Logger;

public class NotebookDayNamePanelController extends AbstractPanelController {
    NotebookDayNamePanelModel model = null;
    NotebookDayNamePanelView view = null;
    
    public NotebookDayNamePanelController(Logger logger) {
    
        super(logger);
        model = new NotebookDayNamePanelModel(logger);
        view = new NotebookDayNamePanelView(this, model, logger);
        addModel(model);
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
