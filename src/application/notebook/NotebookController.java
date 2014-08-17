package application.notebook;

import notebook.abstractc.AbstractController;
import notebook.swing.panels.currentmonthpanel.NotebookCurrentMonthPanelController;

import org.slf4j.Logger;

public class NotebookController extends AbstractController {
    
    private NotebookCurrentMonthPanelController currentMonthPanelController = null;
    
    public NotebookController(Logger logger) {
    
        super(logger);
        
        this.currentMonthPanelController = new NotebookCurrentMonthPanelController(logger);
        currentMonthPanelController.initController();
        
    }
    
    public void initController() {
    
        NotebookModel model = new NotebookModel(getLogger());
        NotebookView view = new NotebookView(this, model, getLogger());
        view.setVisible(true);
        addModel(model);
        addView(view);
    }
    
    public NotebookCurrentMonthPanelController getCurrentMonthPanelController() {
    
        return currentMonthPanelController;
    }
    
    public void setCurrentMonthPanelController(NotebookCurrentMonthPanelController currentMonthPanelController) {
    
        this.currentMonthPanelController = currentMonthPanelController;
    }
    
}
