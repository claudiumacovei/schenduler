package notebook.swing.panels.currentmonthpanel;

import notebook.swing.panels.abstractc.AbstractPanelController;

import org.slf4j.Logger;

public class NotebookCurrentMonthPanelController extends AbstractPanelController {
    NotebookCurrentMonthPanelModel model = null;
    NotebookCurrentMonthPanelView view = null;
    
    public NotebookCurrentMonthPanelController(Logger logger) {
    
        super(logger);
        model = new NotebookCurrentMonthPanelModel(logger);
        view = new NotebookCurrentMonthPanelView(this, model, logger);
        addModel(model);
        addView(view);
    }
    
    public NotebookCurrentMonthPanelModel getModel() {
    
        return model;
    }
    
    public NotebookCurrentMonthPanelView getView() {
    
        return view;
    }
    
    public void setModel(NotebookCurrentMonthPanelModel model) {
    
        this.model = model;
    }
    
    public void setView(NotebookCurrentMonthPanelView view) {
    
        this.view = view;
    }
    
}
