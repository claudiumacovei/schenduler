package application.notebook;

import org.slf4j.Logger;

import application.notebook._abstract.AbstractController;
import application.notebook.panels.currentmonthpanel.NotebookCurrentMonthPanelController;

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
