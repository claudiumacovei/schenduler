package notebook.swing.panels.currentmonthpanel;

import notebook.swing.panels.abstractc.AbstractPanelController;

import org.slf4j.Logger;

public class NotebookCurrentMonthPanelController extends AbstractPanelController {
    
    public NotebookCurrentMonthPanelController(Logger logger) {
    
        super(logger);
        NotebookCurrentMonthPanelModel model = new NotebookCurrentMonthPanelModel(this, logger);
        NotebookCurrentMonthPanelView view = new NotebookCurrentMonthPanelView(model, this, logger);
        view.setVisible(true);
        addModel(model);
        addView(view);
    }
    
}
